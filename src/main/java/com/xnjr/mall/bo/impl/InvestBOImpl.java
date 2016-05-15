/**
 * @Title InvestBOImpl.java 
 * @Package com.xnjr.pop.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午11:07:32 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IInvestBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IInvestDAO;
import com.xnjr.mall.dao.IProjectDAO;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.EInvestStatus;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:07:32 
 * @history:
 */
@Component
public class InvestBOImpl extends PaginableBOImpl<Invest> implements IInvestBO {

    @Autowired
    private IInvestDAO investDAO;

    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public Invest getInvest(String code) {
        Invest invest = null;
        if (StringUtils.isNotBlank(code)) {
            Invest condition = new Invest();
            condition.setCode(code);
            invest = investDAO.select(condition);
        }
        return invest;
    }

    @Override
    public Long getLoanedAmountAmount(String projectCode) {
        Long realTotalAmount = 0l;
        if (StringUtils.isNotBlank(projectCode)) {
            Invest condition = new Invest();
            condition.setProjectCode(projectCode);
            condition.setStatus(EInvestStatus.CONFIRMED.getCode());
            realTotalAmount = investDAO.selectTotalAmount(condition);
        }
        return realTotalAmount;
    }

    @Override
    public List<Invest> queryConfirmedInvestList(String subjectCode) {
        List<Invest> list = null;
        if (StringUtils.isNotBlank(subjectCode)) {
            Invest condition = new Invest();
            condition.setSubjectCode(subjectCode);
            condition.setStatus(EInvestStatus.CONFIRMED.getCode());
            list = investDAO.selectList(condition);
        }
        return list;
    }

    @Override
    public String saveInvest(FDUser user, Project project, Long investAmount) {
        Invest data = new Invest();
        String code = OrderNoGenerater.generateM("I");
        data.setCode(code);
        data.setStatus(EInvestStatus.APPLYING.getCode());
        data.setProjectCode(project.getCode());
        data.setUserId(user.getUserId());
        data.setRealName(user.getRealName());

        data.setInvestAmount(investAmount);
        data.setInvestDatetime(new Date());
        investDAO.insert(data);
        return code;

    }

    @Override
    public void cancelInvest(String code, String remark) {
        Invest data = new Invest();
        data.setCode(code);
        data.setStatus(EInvestStatus.CANCELLED.getCode());
        data.setCheckDatetime(new Date());
        data.setRemark(remark);
        investDAO.cancelInvest(data);
    }

    @Override
    public void confirmInvest(Invest invest, Long investAmount, String remark,
            String subjectCode) {
        invest.setStatus(EInvestStatus.CONFIRMED.getCode());
        invest.setCheckDatetime(new Date());
        invest.setRemark(remark);
        invest.setInvestAmount(investAmount);
        invest.setSubjectCode(subjectCode);

        investDAO.confirmInvest(invest);
    }

    @Override
    public List<Subject> queryMySubjectList(Invest condition) {
        return investDAO.selectMySubjectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IInvestBO#queryInvestList(com.xnjr.mall.domain.Invest)
     */
    @Override
    public List<Invest> queryInvestList(Invest condition) {
        return investDAO.selectList(condition);
    }
}

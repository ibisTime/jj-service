/**
 * @Title WillInvestBOImpl.java 
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

import com.xnjr.mall.bo.IWillInvestBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IProjectDAO;
import com.xnjr.mall.dao.IWillInvestDAO;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.WillInvest;
import com.xnjr.mall.enums.EInvestStatus;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:07:32 
 * @history:
 */
@Component
public class WillInvestBOImpl extends PaginableBOImpl<WillInvest> implements
        IWillInvestBO {

    @Autowired
    private IWillInvestDAO willInvestDAO;

    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public WillInvest getInvest(String code) {
        WillInvest willInvest = null;
        if (StringUtils.isNotBlank(code)) {
            WillInvest condition = new WillInvest();
            condition.setCode(code);
            willInvest = willInvestDAO.select(condition);
        }
        return willInvest;
    }

    @Override
    public String saveInvest(FDUser user, Project project, Long nowAmount,
            String nowNote) {
        WillInvest data = new WillInvest();
        String code = OrderNoGenerater.generateM("WI");
        data.setCode(code);
        data.setStatus(EInvestStatus.APPLYING.getCode());
        data.setProjectCode(project.getCode());
        data.setUserId(user.getUserId());
        data.setRealName(user.getRealName());

        data.setNowAmount(nowAmount);
        data.setNowNote(nowNote);
        data.setInvestDatetime(new Date());
        willInvestDAO.insert(data);
        return code;

    }

    /** 
     * @see com.xnjr.mall.bo.IInvestBO#queryInvestList(com.xnjr.mall.domain.WillInvest)
     */
    @Override
    public List<WillInvest> queryInvestList(WillInvest condition) {
        return willInvestDAO.selectList(condition);
    }
}

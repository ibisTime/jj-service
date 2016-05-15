/**
 * @Title IInvestBO.java 
 * @Package com.xnjr.pop.bo 
 * @Description 
 * @author xieyj  
 * @date 2015年11月13日 上午11:03:47 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.Subject;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:03:47 
 * @history:
 */
public interface IInvestBO extends IPaginableBO<Invest> {

    public Invest getInvest(String code);

    public Long getLoanedAmountAmount(String projectCode);

    /**
     * 查询认购表，跟项目关联
     * @param condition
     * @return 
     * @create: 2016年4月1日 上午6:14:13 xieyj
     * @history:
     */
    public List<Subject> queryMySubjectList(Invest condition);

    public List<Invest> queryInvestList(Invest condition);

    public List<Invest> queryConfirmedInvestList(String subjectCode);

    /**
     * 真实认购
     * @param user
     * @param project
     * @param investAmount
     * @return 
     * @create: 2016年1月19日 下午8:17:11 myb858
     * @history:
     */
    public String saveInvest(FDUser user, Project project, Long investAmount);

    /**
     * 取消认购
     * @param investCode
     * @param remark 
     * @create: 2016年1月19日 下午8:48:20 myb858
     * @history:
     */
    public void cancelInvest(String investCode, String remark);

    /**
     * 确认认购
     * @param invest
     * @param investAmount
     * @param remark
     * @param subjectCode 
     * @create: 2016年1月27日 下午3:48:16 myb858
     * @history:
     */
    public void confirmInvest(Invest invest, Long investAmount, String remark,
            String subjectCode);
}

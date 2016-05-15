package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.domain.WillInvest;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:03:47 
 * @history:
 */
public interface IWillInvestBO extends IPaginableBO<WillInvest> {

    public WillInvest getInvest(String code);

    public List<WillInvest> queryInvestList(WillInvest condition);

    /**
     * 认购申请
     * @param user
     * @param project
     * @param nowAmount
     * @param nowNote
     * @return 
     * @create: 2016年1月19日 下午8:17:11 myb858
     * @history:
     */
    public String saveInvest(FDUser user, Project project, Long nowAmount,
            String nowNote);
}

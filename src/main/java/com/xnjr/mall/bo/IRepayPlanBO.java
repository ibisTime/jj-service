package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.RepayPlan;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.ERepayDetailStatus;

public interface IRepayPlanBO extends IPaginableBO<RepayPlan> {
    /**
     * 流项目导致还款
     * @param invest
     * @param subject 
     * @create: 2016年1月21日 下午4:21:39 myb858
     * @history:
     */
    void cancelSubjectRepay(Invest invest, Subject subject);

    /**
     * 结束项目导致还款
     * @param invest
     * @param business
     * @param subject 
     * @create: 2016年1月21日 下午5:13:25 myb858
     * @history:
     */
    void stopSubjectRepay(Invest invest, List<Business> businessList,
            Subject subject);

    /**
     * 查询还款详情
     * @param code
     * @return 
     * @create: 2016年1月21日 下午8:12:27 wuql
     * @history:
     */
    public RepayPlan getRepayPlan(String code);

    /**
     * 全部还款
     * @param repayPlan
     * @param remark
     * @param status 
     * @create: 2016年1月24日 下午4:47:05 myb858
     * @history:
     */
    void repayAll(RepayPlan repayPlan, String remark, ERepayDetailStatus status);

    RepayPlan sumPP(String userId);

    /**
     * 判断是否只是减去客户收益
     * @param repayPlan
     * @return 
     * @create: 2016年1月27日 下午6:03:02 myb858
     * @history:
     */
    boolean isMinusKHProfitBak(RepayPlan repayPlan);

    public boolean isMinusKHProfit(RepayPlan repayPlan);

    /**
     * 判断当前还款是否需要还本金
     * @param repayPlan
     * @return 
     * @create: 2016年1月30日 上午10:38:50 myb858
     * @history:
     */
    boolean isNeedPrincipal(RepayPlan repayPlan);

}

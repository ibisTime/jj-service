package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.Invest;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.domain.RepayDetail;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.enums.ERepayDetailStatus;

public interface IRepayDetailBO extends IPaginableBO<RepayDetail> {
    /**
     * 流项目导致还款
     * @param invest
     * @param subject 
     * @create: 2016年1月21日 下午4:21:39 myb858
     * @history:
     */
    void cancelSubjectRepay(Invest invest, List<InvestTable> investTableList,
            Subject subject);

    /**
     * 结束项目导致还款
     * @param invest
     * @param business
     * @param subject 
     * @create: 2016年1月21日 下午5:13:25 myb858
     * @history:
     */
    void stopSubjectRepay(Invest invest, List<InvestTable> investTables,
            List<Business> businessList, Subject subject);

    /**
     * 查询还款详情
     * @param code
     * @return 
     * @create: 2016年1月21日 下午8:12:27 wuql
     * @history:
     */
    public RepayDetail getRepayDetail(String code);

    /**
     * 单条还款
     * @param repayDetail
     * @param remark
     * @param status 
     * @create: 2016年1月24日 下午4:47:05 myb858
     * @history:
     */
    void repayDetail(RepayDetail repayDetail, String remark,
            ERepayDetailStatus status);

    /**
     * 判断是否只是减去客户收益
     * @param repayPlan
     * @return 
     * @create: 2016年1月27日 下午6:03:02 myb858
     * @history:
     */
    public boolean isMinusKHProfit(RepayDetail repayDetail);

    public Long getTotalInvest(List<String> towhoList);

    public Long getTotalProfit(List<String> towhoList);

}

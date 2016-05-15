package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.RepayPlan;

/**
 * 还款计划DAO
 * @author: wuql
 * @since: 2016年1月21日 下午6:03:31 
 * @history:
 */
public interface IRepayPlanDAO extends IBaseDAO<RepayPlan> {
    String NAMESPACE = IRepayPlanDAO.class.getName().concat(".");

    public int repayAll(RepayPlan repayPlan);

    public RepayPlan sumPP(RepayPlan condition);
}

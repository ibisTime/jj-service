/**
 * @Title RepayPlanDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author wuql 
 * @date 2016年1月17日 上午10:45:39 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IRepayPlanDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.RepayPlan;

/**
 * 还款计划
 * @author: wuql
 * @since: 2016年1月21日 下午6:09:24 
 * @history:
 */
@Repository("repayPlanDAOImpl")
public class RepayPlanDAOImpl extends AMybatisTemplate implements IRepayPlanDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(RepayPlan data) {
        return super.insert("insert_repayPlan", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(RepayPlan data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public RepayPlan select(RepayPlan condition) {
        return super.select("select_repayPlan", condition, RepayPlan.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(RepayPlan condition) {
        return super.selectTotalCount("select_repayPlan_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<RepayPlan> selectList(RepayPlan condition) {
        return super.selectList("select_repayPlan", condition, RepayPlan.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<RepayPlan> selectList(RepayPlan condition, int start, int count) {
        return super.selectList("select_repayPlan", start, count, condition,
            RepayPlan.class);
    }

    @Override
    public int repayAll(RepayPlan repayPlan) {
        return super.update("update_repayAll", repayPlan);
    }

    @Override
    public RepayPlan sumPP(RepayPlan condition) {
        return super.select("select_sumPP", condition, RepayPlan.class);
    }
}

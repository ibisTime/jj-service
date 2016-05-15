/**
 * @Title RepayDetailDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author wuql 
 * @date 2016年1月17日 上午10:45:39 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IRepayDetailDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.RepayDetail;

/**
 * 还款计划
 * @author: wuql
 * @since: 2016年1月21日 下午6:09:24 
 * @history:
 */
@Repository("repayDetailDAOImpl")
public class RepayDetailDAOImpl extends AMybatisTemplate implements
        IRepayDetailDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(RepayDetail data) {
        return super.insert("insert_repayDetail", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(RepayDetail data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public RepayDetail select(RepayDetail condition) {
        return super.select("select_repayDetail", condition, RepayDetail.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(RepayDetail condition) {
        return super.selectTotalCount("select_repayDetail_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<RepayDetail> selectList(RepayDetail condition) {
        return super.selectList("select_repayDetail", condition,
            RepayDetail.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<RepayDetail> selectList(RepayDetail condition, int start,
            int count) {
        return super.selectList("select_repayDetail", start, count, condition,
            RepayDetail.class);
    }

    @Override
    public int repayDetail(RepayDetail repayPlan) {
        return super.update("update_repayDetail", repayPlan);
    }

    @Override
    public Long getTotalInvest(RepayDetail condition) {
        return super.selectTotalCount("select_totalInvest", condition);
    }

    @Override
    public Long getTotalProfit(RepayDetail condition) {
        return super.selectTotalCount("select_totalProfit", condition);
    }
}

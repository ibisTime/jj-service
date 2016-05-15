/**
 * @Title HLOrderDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:19:23 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IHLOrderDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.HLOrder;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:19:23 
 * @history:
 */
@Repository("hlOrderDAOImpl")
public class HLOrderDAOImpl extends AMybatisTemplate implements IHLOrderDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(HLOrder data) {
        return super.insert(NAMESPACE.concat("insert_hlOrder"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(HLOrder data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public HLOrder select(HLOrder condition) {
        return super.select(NAMESPACE.concat("select_hlOrder"), condition,
            HLOrder.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(HLOrder condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_hlOrder_count"),
            condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<HLOrder> selectList(HLOrder condition) {
        return super.selectList(NAMESPACE.concat("select_hlOrder"), condition,
            HLOrder.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<HLOrder> selectList(HLOrder condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_hlOrder"), start,
            count, condition, HLOrder.class);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.account.dao.IHLOrderDAO#updateApproveOrder(com.ibis.account.domain.HLOrder)
     */
    @Override
    public int updateApproveOrder(HLOrder data) {
        return super.update(NAMESPACE.concat("update_approve_order"), data);
    }

}

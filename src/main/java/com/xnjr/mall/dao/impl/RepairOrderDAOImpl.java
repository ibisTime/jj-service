/**
 * @Title RepairOrderDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:02:26 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IRepairOrderDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.RepairOrder;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:02:26 
 * @history:
 */
@Repository("repairOrderDAOImpl")
public class RepairOrderDAOImpl extends AMybatisTemplate implements
        IRepairOrderDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(RepairOrder data) {
        return super.insert(NAMESPACE.concat("insert_repairOrder"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(RepairOrder data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public RepairOrder select(RepairOrder condition) {
        return super.select(NAMESPACE.concat("select_repairOrder"), condition,
            RepairOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(RepairOrder condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_repairOrder_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<RepairOrder> selectList(RepairOrder condition) {
        return super.selectList(NAMESPACE.concat("select_repairOrder"),
            condition, RepairOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<RepairOrder> selectList(RepairOrder condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_repairOrder"), start,
            count, condition, RepairOrder.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IRepairOrderDAO#updateStatus(com.xnjr.mall.domain.RepairOrder)
     */
    @Override
    public int updateStatus(RepairOrder data) {
        return super.update("update_status", data);
    }

}

/**
 * @Title LogisticsDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 上午11:52:19 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ILogisticsDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Logistics;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 上午11:52:19 
 * @history:
 */
@Repository("logisticsDAOImpl")
public class LogisticsDAOImpl extends AMybatisTemplate implements ILogisticsDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Logistics data) {
        return super.insert(NAMESPACE.concat("insert_logistics"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Logistics data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Logistics select(Logistics condition) {
        return super.select(NAMESPACE.concat("select_logistics"), condition,
            Logistics.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Logistics condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_logistics_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Logistics> selectList(Logistics condition) {
        return super.selectList(NAMESPACE.concat("select_logistics"),
            condition, Logistics.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Logistics> selectList(Logistics condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_logistics"), start,
            count, condition, Logistics.class);
    }

}

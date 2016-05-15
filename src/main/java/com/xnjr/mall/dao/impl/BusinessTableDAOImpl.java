/**
 * @Title BusinessTableDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年1月17日 上午11:36:42 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IBusinessTableDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.BusinessTable;

/** 
 * 业务核算
 * @author: xieyj 
 * @since: 2016年1月17日 上午11:36:42 
 * @history:
 */
@Repository("businessTableDAOImpl")
public class BusinessTableDAOImpl extends AMybatisTemplate implements
        IBusinessTableDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(BusinessTable data) {
        return super.insert("insert_businessTable", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(BusinessTable data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public BusinessTable select(BusinessTable condition) {
        return super.select("select_businessTable", condition,
            BusinessTable.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(BusinessTable condition) {
        return super.selectTotalCount("select_businessTable_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<BusinessTable> selectList(BusinessTable condition) {
        return super.selectList("select_businessTable", condition,
            BusinessTable.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<BusinessTable> selectList(BusinessTable condition, int start,
            int count) {
        return super.selectList("select_businessTable", start, count,
            condition, BusinessTable.class);
    }

    @Override
    public int deleteBusinessTable(BusinessTable data) {
        return super.delete("delete_businessTable", data);
    }
}

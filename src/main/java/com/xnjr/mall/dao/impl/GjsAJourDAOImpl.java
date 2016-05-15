/**
 * @Title AJourDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:55 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGjsAJourDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GjsAccountJour;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:55 
 * @history:
 */
@Repository("gjsAJourDAOImpl")
public class GjsAJourDAOImpl extends AMybatisTemplate implements IGjsAJourDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(GjsAccountJour data) {
        return super.insert(NAMESPACE.concat("insert_gjsAccountJour"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(GjsAccountJour data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public GjsAccountJour select(GjsAccountJour condition) {
        return super.select(NAMESPACE.concat("select_gjsAccountJour"),
            condition, GjsAccountJour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(GjsAccountJour condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_gjsAccountJour_count"), condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<GjsAccountJour> selectList(GjsAccountJour condition) {
        return super.selectList(NAMESPACE.concat("select_gjsAccountJour"),
            condition, GjsAccountJour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<GjsAccountJour> selectList(GjsAccountJour condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_gjsAccountJour"),
            start, count, condition, GjsAccountJour.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IGjsAJourDAO#updateCheck(com.xnjr.mall.domain.GjsAccountJour)
     */
    @Override
    public int updateCheck(GjsAccountJour data) {
        return super.update("update_gjsAccountCheck", data);
    }
}

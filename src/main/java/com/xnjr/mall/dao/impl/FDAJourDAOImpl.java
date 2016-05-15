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

import com.xnjr.mall.dao.IFDAJourDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDAccountJour;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:55 
 * @history:
 */
@Repository("fdAJourDAOImpl")
public class FDAJourDAOImpl extends AMybatisTemplate implements IFDAJourDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDAccountJour data) {
        return super.insert(NAMESPACE.concat("insert_fdAccountJour"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDAccountJour data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDAccountJour select(FDAccountJour condition) {
        return super.select(NAMESPACE.concat("select_fdAccountJour"),
            condition, FDAccountJour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDAccountJour condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdAccountJour_count"), condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDAccountJour> selectList(FDAccountJour condition) {
        return super.selectList(NAMESPACE.concat("select_fdAccountJour"),
            condition, FDAccountJour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDAccountJour> selectList(FDAccountJour condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdAccountJour"),
            start, count, condition, FDAccountJour.class);
    }

    /** 
     * @see com.xnjr.IFDAJourDAO.dao.ibis.account.dao.IAJourDAO#updateCheckInfo(com.ibis.account.domain.FDAccountJour)
     */
    @Override
    public int doCheckAccount(FDAccountJour data) {
        return super.update(NAMESPACE.concat("update_check_fdAccountJour"),
            data);
    }
}

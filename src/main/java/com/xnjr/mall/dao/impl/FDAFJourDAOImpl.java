/**
 * @Title AFJourDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:43 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDAFJourDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDAccountFrozenJour;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:43 
 * @history:
 */
@Repository("fdAfJourDAOImpl")
public class FDAFJourDAOImpl extends AMybatisTemplate implements IFDAFJourDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDAccountFrozenJour data) {
        return super.insert(NAMESPACE.concat("insert_fdAfJour"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDAccountFrozenJour data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDAccountFrozenJour select(FDAccountFrozenJour condition) {
        return super.select(NAMESPACE.concat("select_fdAfJour"), condition,
            FDAccountFrozenJour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDAccountFrozenJour condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdAfJour_count"), condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDAccountFrozenJour> selectList(FDAccountFrozenJour condition) {
        return super.selectList(NAMESPACE.concat("select_fdAfJour"), condition,
            FDAccountFrozenJour.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDAccountFrozenJour> selectList(FDAccountFrozenJour condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_fdAfJour"), start,
            count, condition, FDAccountFrozenJour.class);
    }

}

/**
 * @Title FDAccountDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:26 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDAccountDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDAccount;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:26 
 * @history:
 */
@Repository("fdAccountDAOImpl")
public class FDAccountDAOImpl extends AMybatisTemplate implements IFDAccountDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDAccount data) {
        return super.insert(NAMESPACE.concat("insert_fdAccount"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDAccount data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDAccount select(FDAccount condition) {
        return super.select(NAMESPACE.concat("select_fdAccount"), condition,
            FDAccount.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDAccount condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdAccount_count"), condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDAccount> selectList(FDAccount condition) {
        return super.selectList(NAMESPACE.concat("select_fdAccount"),
            condition, FDAccount.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDAccount> selectList(FDAccount condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_fdAccount"), start,
            count, condition, FDAccount.class);
    }

    /** 
     * @see com.xnjr.IFDFDAccountDAO.dao.ibis.account.dao.IFDAccountDAO#updateAmount(com.ibis.account.domain.FDAccount)
     */
    @Override
    public int updateAmount(FDAccount data) {
        return super.update(NAMESPACE.concat("update_amount"), data);
    }

    /** 
     * @see com.xnjr.IFDFDAccountDAO.dao.ibis.account.dao.IFDAccountDAO#updateFrozenAmount(com.ibis.account.domain.FDAccount)
     */
    @Override
    public int updateFrozenAmount(FDAccount data) {
        return super.update(NAMESPACE.concat("update_frozen_amount"), data);
    }

    /** 
     * @see com.xnjr.IFDFDAccountDAO.dao.ibis.account.dao.IFDAccountDAO#updateStatus(com.ibis.account.domain.FDAccount)
     */
    @Override
    public int updateStatus(FDAccount data) {
        return super.update(NAMESPACE.concat("update_status"), data);
    }

    @Override
    public int updateRealName(FDAccount data) {
        return super.update(NAMESPACE.concat("update_realName"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.IFDAccountDAO#selectTotalAmount(com.xnjr.mall.domain.FDAccount)
     */
    @Override
    public Long selectTotalAmount(FDAccount data) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdAccount_totalAmount"), data);
    }
}

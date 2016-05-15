/**
 * @Title FDUserAccountDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:26 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDUserAccountDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDUserAccount;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:26 
 * @history:
 */
@Repository("fdUserAccountDAOImpl")
public class FDUserAccountDAOImpl extends AMybatisTemplate implements
        IFDUserAccountDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDUserAccount data) {
        return super.insert(NAMESPACE.concat("insert_fdUserAccount"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDUserAccount data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDUserAccount select(FDUserAccount condition) {
        return super.select(NAMESPACE.concat("select_fdUserAccount"),
            condition, FDUserAccount.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDUserAccount condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdUserAccount_count"), condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDUserAccount> selectList(FDUserAccount condition) {
        return super.selectList(NAMESPACE.concat("select_fdUserAccount"),
            condition, FDUserAccount.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDUserAccount> selectList(FDUserAccount condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdUserAccount"),
            start, count, condition, FDUserAccount.class);
    }

    /** 
     * @see com.xnjr.IFDFDUserAccountDAO.dao.ibis.account.dao.IFDUserAccountDAO#updateAmount(com.ibis.account.domain.FDUserAccount)
     */
    @Override
    public int updateAmount(FDUserAccount data) {
        return super.update(NAMESPACE.concat("update_fdUserAccountAmount"),
            data);
    }

    /** 
     * @see com.xnjr.IFDFDUserAccountDAO.dao.ibis.account.dao.IFDUserAccountDAO#updateFrozenAmount(com.ibis.account.domain.FDUserAccount)
     */
    @Override
    public int updateFrozenAmount(FDUserAccount data) {
        return super.update(
            NAMESPACE.concat("update_fdUserAccountFrozenAmount"), data);
    }

    /** 
     * @see com.xnjr.IFDFDUserAccountDAO.dao.ibis.account.dao.IFDUserAccountDAO#updateStatus(com.ibis.account.domain.FDUserAccount)
     */
    @Override
    public int updateStatus(FDUserAccount data) {
        return super.update(NAMESPACE.concat("update_fdUserAccountStatus"),
            data);
    }

    @Override
    public int updateRealName(FDUserAccount data) {
        return super.update(NAMESPACE.concat("update_fdUserAccountRealName"),
            data);
    }

}

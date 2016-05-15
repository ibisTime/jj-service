/**
 * @Title FDCompanyAccountDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:26 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDCompanyAccountDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDCompanyAccount;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:26 
 * @history:
 */
@Repository("fdCompanyAccountDAOImpl")
public class FDCompanyAccountDAOImpl extends AMybatisTemplate implements
        IFDCompanyAccountDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDCompanyAccount data) {
        return super.insert(NAMESPACE.concat("insert_fdCompanyAccount"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDCompanyAccount data) {
        return 0;
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDCompanyAccount select(FDCompanyAccount condition) {
        return super.select(NAMESPACE.concat("select_fdCompanyAccount"),
            condition, FDCompanyAccount.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDCompanyAccount condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdCompanyAccount_count"), condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDCompanyAccount> selectList(FDCompanyAccount condition) {
        return super.selectList(NAMESPACE.concat("select_fdCompanyAccount"),
            condition, FDCompanyAccount.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDCompanyAccount> selectList(FDCompanyAccount condition,
            int start, int count) {
        return super.selectList(NAMESPACE.concat("select_fdCompanyAccount"),
            start, count, condition, FDCompanyAccount.class);
    }

    /** 
     * @see com.xnjr.IFDFDCompanyAccountDAO.dao.ibis.account.dao.IFDCompanyAccountDAO#updateAmount(com.ibis.account.domain.FDCompanyAccount)
     */
    @Override
    public int updateAmount(FDCompanyAccount data) {
        return super.update(NAMESPACE.concat("update_fdCompanyAccountAmount"),
            data);
    }

    /** 
     * @see com.xnjr.IFDFDCompanyAccountDAO.dao.ibis.account.dao.IFDCompanyAccountDAO#updateFrozenAmount(com.ibis.account.domain.FDCompanyAccount)
     */
    @Override
    public int updateFrozenAmount(FDCompanyAccount data) {
        return super.update(
            NAMESPACE.concat("update_fdCompanyAccountFrozenAmount"), data);
    }

    /** 
     * @see com.xnjr.IFDFDCompanyAccountDAO.dao.ibis.account.dao.IFDCompanyAccountDAO#updateStatus(com.ibis.account.domain.FDCompanyAccount)
     */
    @Override
    public int updateStatus(FDCompanyAccount data) {
        return super.update(NAMESPACE.concat("update_fdCompanyAccountStatus"),
            data);
    }
}

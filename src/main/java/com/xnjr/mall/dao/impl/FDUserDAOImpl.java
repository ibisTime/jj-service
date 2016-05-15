/**
 * @Title FDUserDAOImpl.java 
 * @Package com.ibis.pz.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午10:22:53 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDUserDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDUser;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午10:22:53 
 * @history:
 */
@Repository("fdUserDAOImpl")
public class FDUserDAOImpl extends AMybatisTemplate implements IFDUserDAO {

    /** 
     * @see com.ibis.pz.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDUser data) {
        return super.insert(NAMESPACE.concat("insert_fdUser"), data);
    }

    /** 
     * @see com.ibis.pz.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDUser data) {
        return 0;
    }

    /** 
     * @see com.ibis.pz.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDUser select(FDUser condition) {
        return super.select(NAMESPACE.concat("select_fdUser"), condition,
            FDUser.class);
    }

    /** 
     * @see com.ibis.pz.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDUser condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_fdUser_count"),
            condition);
    }

    /** 
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDUser> selectList(FDUser condition) {
        return super.selectList(NAMESPACE.concat("select_fdUser"), condition,
            FDUser.class);
    }

    /** 
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDUser> selectList(FDUser condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_fdUser"), start,
            count, condition, FDUser.class);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.pz.IFDUserDAO#updateIdentity(com.FDUser.pz.domain.FDUserDO)
     */
    @Override
    public int updateIdentity(FDUser data) {
        return super.update(NAMESPACE.concat("update_fdUserIdentity"), data);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.pz.IFDUserDAO#updateTradePwd(com.FDUser.pz.domain.FDUserDO)
     */
    @Override
    public int updateTradePwd(FDUser data) {
        return super.update(NAMESPACE.concat("update_fdUserTradePwd"), data);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.pz.IFDUserDAO#updateLoginPwd(com.FDUser.pz.domain.FDUserDO)
     */
    @Override
    public int updateLoginPwd(FDUser data) {
        return super.update(NAMESPACE.concat("update_fdUserLoginPwd"), data);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.pz.IFDUserDAO#updateLoginPwd(com.FDUser.pz.domain.FDUserDO)
     */
    @Override
    public int updateMobile(FDUser data) {
        return super.update(NAMESPACE.concat("update_fdUserMobile"), data);
    }

    @Override
    public int doKYC(FDUser data) {
        return super.update(NAMESPACE.concat("update_fdUserKYC"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.IFDUserDAO#insertFDUser(com.xnjr.mall.domain.FDUser)
     */
    @Override
    public int quickInsertFDUser(FDUser data) {
        return super.insert(NAMESPACE.concat("quick_insert_fdUser"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.IFDUserDAO#updateIndividual(com.xnjr.mall.domain.FDUser)
     */
    @Override
    public int doKYCIndividual(FDUser data) {
        return super.update(NAMESPACE.concat("update_fdUserKYCIndividual"),
            data);

    }
}

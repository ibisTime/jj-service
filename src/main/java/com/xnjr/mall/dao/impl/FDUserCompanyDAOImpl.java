package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDUserCompanyDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;

/** 
 * 用户企业关联DAO
 * @author: wuql
 * @since: 2016年1月15日 上午11:10:29 
 * @history:
 */
@Repository("fdUserCompanyDAOImpl")
public class FDUserCompanyDAOImpl extends AMybatisTemplate implements
        IFDUserCompanyDAO {

    /**
     * @see com.std.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDUserCompany data) {
        return super.insert(NAMESPACE.concat("insert_fdUserCompany"), data);
    }

    /**
     * @see com.std.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDUserCompany data) {
        return super.delete(NAMESPACE.concat("delete_fdUserCompany"), data);
    }

    /**
     * @see com.std.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDUserCompany select(FDUserCompany condition) {
        return (FDUserCompany) super.select(
            NAMESPACE.concat("select_fdUserCompany"), condition,
            FDUserCompany.class);
    }

    /** 
     * @see com.std.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDUserCompany condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdUserCompany_count"), condition);
    }

    /** 
     * @see com.std.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDUserCompany> selectList(FDUserCompany condition) {
        return super.selectList(NAMESPACE.concat("select_fdUserCompany"),
            condition, FDUserCompany.class);
    }

    /** 
     * @see com.std.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDUserCompany> selectList(FDUserCompany condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdUserCompany"),
            start, count, condition, FDUserCompany.class);
    }

    @Override
    public List<FDCompany> selectCompanyList(FDUserCompany condition) {
        return super.selectList(NAMESPACE.concat("select_fdCompanyList"),
            condition, FDCompany.class);
    }

    @Override
    public Long selectCompanyTotalCount(FDUserCompany condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdCompanyList_count"), condition);
    }

    @Override
    public List<FDUser> selectUserList(FDUserCompany condition) {
        return super.selectList(NAMESPACE.concat("select_fdUserList"),
            condition, FDUser.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IFDUserCompanyDAO#updateUserCompany(com.xnjr.mall.domain.FDUserCompany)
     */
    @Override
    public int updateUserCompany(FDUserCompany data) {
        return super.update("update_fdUserCompany", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IFDUserCompanyDAO#updateKYCUserCompany(com.xnjr.mall.domain.FDUserCompany)
     */
    @Override
    public int updateKYCUserCompany(FDUserCompany data) {
        return super.update("update_kycFdUserCompany", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IFDUserCompanyDAO#selectCompanyPage(com.xnjr.mall.domain.FDUserCompany)
     */
    @Override
    public List<FDCompany> selectCompanyList(int start, int count,
            FDUserCompany condition) {
        return super.selectList("select_fdCompanyList", start, count,
            condition, FDCompany.class);
    }
}

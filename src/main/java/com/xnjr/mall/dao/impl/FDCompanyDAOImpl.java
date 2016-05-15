package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDCompanyDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDCompany;

/** 
 * 公司列表
 * @author: wuql
 * @since: 2016年1月14日 下午2:26:27 
 * @history:
 */
@Repository("fdCompanyDAOImpl")
public class FDCompanyDAOImpl extends AMybatisTemplate implements IFDCompanyDAO {

    /**
     * @see com.std.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDCompany data) {
        return super.insert("insert_fdCompany", data);
    }

    /** 
     * @see com.std.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDCompany data) {
        return super.delete("delete_fdCompany", data);
    }

    /**
     * @see com.std.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDCompany select(FDCompany condition) {
        return super.select("select_fdCompany", condition, FDCompany.class);
    }

    /**
     * @see com.std.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDCompany condition) {
        return super.selectTotalCount("select_fdCompany_count", condition);
    }

    /**
     * @see com.std.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDCompany> selectList(FDCompany condition) {
        return super.selectList("select_fdCompany", condition, FDCompany.class);
    }

    /**
     * @see com.std.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDCompany> selectList(FDCompany condition, int start, int count) {
        return super.selectList("select_fdCompany", start, count, condition,
            FDCompany.class);
    }

    @Override
    public int updatePicture(FDCompany data) {
        return super.update("update_fdCompanyPicture", data);
    }

    @Override
    public int updateCompany(FDCompany data) {
        return super.update("update_fdCompany", data);
    }

    @Override
    public int doKYC(FDCompany data) {
        return super.update("update_fdCompanyKYC", data);
    }
}

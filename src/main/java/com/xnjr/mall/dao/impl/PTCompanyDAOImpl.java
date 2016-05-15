package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IPTCompanyDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.PTCompany;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午8:25:28 
 * @history:
 */
@Repository("ptCompanyDAOImpl")
public class PTCompanyDAOImpl extends AMybatisTemplate implements IPTCompanyDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(PTCompany data) {
        return super.insert("insert_pt_company", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(PTCompany data) {
        return super.delete("delete_pt_company", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public PTCompany select(PTCompany condition) {
        return super.select("select_pt_company", condition, PTCompany.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(PTCompany condition) {
        return super.selectTotalCount("select_pt_company_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<PTCompany> selectList(PTCompany condition) {
        return super
            .selectList("select_pt_company", condition, PTCompany.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<PTCompany> selectList(PTCompany condition, int start, int count) {
        return super.selectList("select_pt_company", start, count, condition,
            PTCompany.class);
    }

    /**
     * @see com.xnjr.mall.dao.IPTCompanyDAO#updatePlatCompany(com.xnjr.mall.domain.PTCompany)
     */
    @Override
    public int updatePTCompany(PTCompany data) {
        return super.update("update_pt_company", data);
    }

}

/**
 * @Title PTCompanyPersonDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年3月4日 下午9:50:21 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IPTCompanyPersonDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.PTCompanyPerson;

/** 
 * @author: xieyj 
 * @since: 2016年3月4日 下午9:50:21 
 * @history:
 */
@Repository("ptCompanyPersonDAOImpl")
public class CompanyPersonsDAOImpl extends AMybatisTemplate implements
        IPTCompanyPersonDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(PTCompanyPerson data) {
        return super.insert("insert_ptCompanyPerson", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(PTCompanyPerson data) {
        return super.delete("delete_ptCompanyPerson", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public PTCompanyPerson select(PTCompanyPerson condition) {
        return super.select("select_ptCompanyPerson", condition,
            PTCompanyPerson.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(PTCompanyPerson condition) {
        return super
            .selectTotalCount("select_ptCompanyPerson_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<PTCompanyPerson> selectList(PTCompanyPerson condition) {
        return super.selectList("select_ptCompanyPerson", condition,
            PTCompanyPerson.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<PTCompanyPerson> selectList(PTCompanyPerson condition,
            int start, int count) {
        return super.selectList("select_ptCompanyPerson", start, count,
            condition, PTCompanyPerson.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyPersonDAO#deleteCompanyPersonsByCompany(com.xnjr.mall.domain.PTCompanyPerson)
     */
    @Override
    public int deletePTCompanyPersonByCompany(PTCompanyPerson condition) {
        return super.delete("delete_ptCompanyPerson_byCompany", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.IPTCompanyPersonDAO#update(com.xnjr.mall.domain.PTCompanyPerson)
     */
    @Override
    public int update(PTCompanyPerson condition) {
        return super.update("update_ptCompanyPerson", condition);
    }
}

/**
 * @Title SubjectDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月16日 下午9:11:56 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ISubjectDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Subject;

/** 
 * @author: haiqingzheng 
 * @since: 2016年1月16日 下午9:11:56 
 * @history:
 */
@Repository("subjectDAOImpl")
public class SubjectDAOImpl extends AMybatisTemplate implements ISubjectDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Subject data) {
        return super.insert("insert_subject", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Subject data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Subject select(Subject condition) {
        return super.select("select_subject", condition, Subject.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Subject condition) {
        return super.selectTotalCount("select_subject_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Subject> selectList(Subject condition) {
        return super.selectList("select_subject", condition, Subject.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public List<Subject> selectMySubjectList(Subject condition) {
        return super.selectList("select_mySubject", condition, Subject.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Subject> selectList(Subject condition, int start, int count) {
        return super.selectList("select_subject", start, count, condition,
            Subject.class);
    }

    @Override
    public int startSubject(Subject data) {
        return super.update("update_startSubject", data);
    }

    @Override
    public int cancelSubject(Subject data) {
        return super.update("update_cancelSubject", data);
    }

    @Override
    public int stopSubject(Subject data) {
        return super.update("update_stopSubject", data);
    }

    @Override
    public int updateTotal(Subject data) {
        return super.update("update_updateTotal", data);
    }

}

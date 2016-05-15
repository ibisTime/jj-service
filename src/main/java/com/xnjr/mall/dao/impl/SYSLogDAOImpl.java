/**
 * @Title SYSLogDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午8:58:58 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ISYSLogDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.SYSLog;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午8:58:58 
 * @history:
 */
@Repository("sysLogDAOImpl")
public class SYSLogDAOImpl extends AMybatisTemplate implements ISYSLogDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(SYSLog data) {
        return super.insert("insert_sysLog", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(SYSLog data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public SYSLog select(SYSLog condition) {
        return super.select("select_sysLog", condition, SYSLog.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(SYSLog condition) {
        return super.selectTotalCount("select_sysLog_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<SYSLog> selectList(SYSLog condition) {
        return super.selectList("select_sysLog", condition, SYSLog.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<SYSLog> selectList(SYSLog condition, int start, int count) {
        return super.selectList("select_sysLog", start, count, condition,
            SYSLog.class);
    }

}

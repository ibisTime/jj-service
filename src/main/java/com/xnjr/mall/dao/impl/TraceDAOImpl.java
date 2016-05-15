package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ITraceDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Trace;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午10:32:12 
 * @history:
 */
@Repository("traceDAOImpl")
public class TraceDAOImpl extends AMybatisTemplate implements ITraceDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Trace data) {
        return super.insert("insert_trace", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Trace data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Trace select(Trace condition) {
        return super.select("select_trace", condition, Trace.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Trace condition) {
        return super.selectTotalCount("select_trace_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Trace> selectList(Trace condition) {
        return super.selectList("select_trace", condition, Trace.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Trace> selectList(Trace condition, int start, int count) {
        return super.selectList("select_trace", start, count, condition,
            Trace.class);
    }

    /** 
     * @see com.xnjr.mall.dao.ITraceDAO#selectTotalCountByBussinessAndUser(com.xnjr.mall.domain.Trace)
     */
    @Override
    public Long selectTotalCountByBussinessAndUser(Trace data) {
        return super.selectTotalCount("select_trace_count_bussinessAndUser",
            data);
    }
}

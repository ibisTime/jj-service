package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDUserLoginLogDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDUserLoginLog;

/**
 * 
 * @author: luoqi 
 * @since: 2015年3月7日 下午2:00:12 
 * @history:
 */
@Repository("fdUserLoginLogDAOImpl")
public class FDUserLoginLogDAOImpl extends AMybatisTemplate implements
        IFDUserLoginLogDAO {

    /**
     * @see com.ibis.pz.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDUserLoginLog data) {
        return super.insert(NAMESPACE.concat("insert_fdUserLoginLog"), data);
    }

    /** 
     * @see com.ibis.pz.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDUserLoginLog data) {
        return 0;
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDUserLoginLog select(FDUserLoginLog condition) {
        return super.select(NAMESPACE.concat("select_fdUserLoginLog"),
            condition, FDUserLoginLog.class);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDUserLoginLog condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdUserLoginLog_count"), condition);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDUserLoginLog> selectList(FDUserLoginLog condition) {
        return super.selectList(NAMESPACE.concat("select_fdUserLoginLog"),
            condition, FDUserLoginLog.class);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDUserLoginLog> selectList(FDUserLoginLog condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdUserLoginLog"),
            start, count, condition, FDUserLoginLog.class);
    }

    @Override
    public FDUserLoginLog selectLatestUserLoginLog(FDUserLoginLog condition) {
        return super.select(NAMESPACE.concat("select_latestFdUserLoginLog"),
            condition, FDUserLoginLog.class);
    }

}

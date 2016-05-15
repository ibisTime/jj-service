package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IFDUserIdentifyDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.FDUserIdentify;

/**
d * @author: luoqi 
 * @since: 2015年3月7日 下午6:37:56 
 * @history:
 */
@Repository("fdUserIdentifyDAOImpl")
public class FDUserIdentifyDAOImpl extends AMybatisTemplate implements
        IFDUserIdentifyDAO {

    /**
     * @see com.ibis.pz.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(FDUserIdentify data) {
        return super.insert(NAMESPACE.concat("insert_fdUserIdentify"), data);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(FDUserIdentify data) {
        return 0;
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public FDUserIdentify select(FDUserIdentify condition) {
        return super.select(NAMESPACE.concat("select_fdUserIdentify"),
            condition, FDUserIdentify.class);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(FDUserIdentify condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_fdUserIdentify_count"), condition);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<FDUserIdentify> selectList(FDUserIdentify condition) {
        return super.selectList(NAMESPACE.concat("select_fdUserIdentify"),
            condition, FDUserIdentify.class);
    }

    /**
     * @see com.ibis.pz.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<FDUserIdentify> selectList(FDUserIdentify condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_fdUserIdentify"),
            start, count, condition, FDUserIdentify.class);
    }

}

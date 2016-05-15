package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IBKSubbranchDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.BKSubbranch;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 上午10:13:00 
 * @history:
 */
@Repository("bkSubbranchDAOImpl")
public class BKSubbranchDAOImpl extends AMybatisTemplate implements
        IBKSubbranchDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(BKSubbranch data) {
        return super.insert("insert_bkSubbranch", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(BKSubbranch data) {
        return super.delete("delete_bkSubbranch", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public BKSubbranch select(BKSubbranch condition) {
        return super.select("select_bkSubbranch", condition, BKSubbranch.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(BKSubbranch condition) {
        return super.selectTotalCount("select_bkSubbranch_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<BKSubbranch> selectList(BKSubbranch condition) {
        return super.selectList("select_bkSubbranch", condition,
            BKSubbranch.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<BKSubbranch> selectList(BKSubbranch condition, int start,
            int count) {
        return super.selectList("select_bkSubbranch", start, count, condition,
            BKSubbranch.class);
    }

    /**
     * @see com.xnjr.mall.dao.IBKSubbranchDAO#updatePlatBank(com.xnjr.mall.domain.BKSubbranch)
     */
    @Override
    public int updateBKSubbranch(BKSubbranch data) {
        return super.update("update_bkSubbranch", data);
    }

    /** 
     * @see com.xnjr.mall.dao.IBKSubbranchDAO#updatePass(com.xnjr.mall.domain.BKSubbranch)
     */
    @Override
    public int checkBKSubbranch(BKSubbranch data) {
        return super.update("check_bkSubbranch", data);
    }
}

package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IBKBankDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.BKBank;

/** 
 * @author: miyb 
 * @since: 2015-6-16 上午10:43:51 
 * @history:
 */
@Repository("bkBankDAOImpl")
public class BKBankDAOImpl extends AMybatisTemplate implements IBKBankDAO {

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(BKBank data) {
        return super.insert(NAMESPACE.concat("insert_bkBank"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(BKBank data) {
        return super.delete(NAMESPACE.concat("delete_bkBank"), data);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public BKBank select(BKBank condition) {
        return (BKBank) super.select(NAMESPACE.concat("select_bkBank"),
            condition, BKBank.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(BKBank condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_bkBank_count"),
            condition);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<BKBank> selectList(BKBank condition) {
        return super.selectList(NAMESPACE.concat("select_bkBank"), condition,
            BKBank.class);
    }

    /** 
     * @see com.ibis.account.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<BKBank> selectList(BKBank condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_bkBank"), start,
            count, condition, BKBank.class);
    }

    /** 
     * @see com.xnjr.account.dao.ibis.account.dao.IBankDAO#update(com.ibis.account.domain.Bank)
     */
    @Override
    public int update(BKBank data) {
        return super.update(NAMESPACE.concat("update_bkBank"), data);
    }

}

/**
 * @Title GjsGjsAccountDAOImpl.java 
 * @Package com.ibis.account.dao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-2-14 下午2:18:26 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGjsAccountDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.GjsAccount;

/** 
 * @author: miyb 
 * @since: 2015-2-14 下午2:18:26 
 * @history:
 */
@Repository("gjsAccountDAOImpl")
public class GjsAccountDAOImpl extends AMybatisTemplate implements
        IGjsAccountDAO {

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(GjsAccount data) {
        return super.insert(NAMESPACE.concat("insert_gjsAccount"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(GjsAccount data) {
        return 0;
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public GjsAccount select(GjsAccount condition) {
        return super.select(NAMESPACE.concat("select_gjsAccount"), condition,
            GjsAccount.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(GjsAccount condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_gjsAccount_count"), condition);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<GjsAccount> selectList(GjsAccount condition) {
        return super.selectList(NAMESPACE.concat("select_gjsAccount"),
            condition, GjsAccount.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<GjsAccount> selectList(GjsAccount condition, int start,
            int count) {
        return super.selectList(NAMESPACE.concat("select_gjsAccount"), start,
            count, condition, GjsAccount.class);
    }

    /**
     * @see com.xnjr.mall.dao.IGjsAccountDAO#updateAmount(com.xnjr.mall.domain.GjsAccount)
     */
    @Override
    public int updateAmount(GjsAccount data) {
        return super.update(NAMESPACE.concat("update_gjsAccountAmount"), data);
    }

    /**
     * 
     * @see com.xnjr.mall.dao.IGjsAccountDAO#updateFrozenAmount(com.xnjr.mall.domain.GjsAccount)
     */
    @Override
    public int updateFrozenAmount(GjsAccount data) {
        return super.update(NAMESPACE.concat("update_gjsAccountFrozenAmount"),
            data);
    }

    /**
     * @see com.xnjr.mall.dao.IGjsAccountDAO#updateStatus(com.xnjr.mall.domain.GjsAccount)
     */
    @Override
    public int updateStatus(GjsAccount data) {
        return super.update(NAMESPACE.concat("update_gjsAccountStatus"), data);
    }

}

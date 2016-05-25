package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ICartDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Cart;

/**
 * @author: luoqi 
 * @since: 2015年3月7日 下午3:49:54 
 * @history:
 */
@Repository("cartDAOImpl")
public class CartDAOImpl extends AMybatisTemplate implements ICartDAO {

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Cart data) {
        return super.insert(NAMESPACE.concat("insert_cart"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Cart data) {
        return super.delete(NAMESPACE.concat("delete_cart"), data);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Cart select(Cart condition) {
        return super.select(NAMESPACE.concat("select_cart"), condition,
            Cart.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Cart condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_cart_count"),
            condition);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Cart> selectList(Cart condition) {
        return super.selectList(NAMESPACE.concat("select_cart"), condition,
            Cart.class);
    }

    /**
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Cart> selectList(Cart condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_cart"), start, count,
            condition, Cart.class);
    }

    /**
     * @see com.xnjr.mall.dao.ICartDAO#update(com.xnjr.mall.domain.Cart)
     */
    @Override
    public int update(Cart data) {
        return super.update(NAMESPACE.concat("update_cart"), data);
    }
}

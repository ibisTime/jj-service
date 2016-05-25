/**
 * @Title CartAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月24日 下午10:27:08 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.ICartAO;
import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 下午10:27:08 
 * @history:
 */
@Service
public class CartAOImpl implements ICartAO {

    @Autowired
    ICartBO cartBO;

    /** 
     * @see com.xnjr.mall.ao.ICartAO#addCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public String addCart(Cart data) {
        return cartBO.saveCart(data);
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#editCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public int editCart(Cart data) {
        if (!cartBO.isCartExist(data.getCode())) {
            throw new BizException("xn0000", "购物车编号不存在");
        }
        return cartBO.refreshCart(data);
    }

    @Override
    public int dropCart(String code) {
        if (!cartBO.isCartExist(code)) {
            throw new BizException("xn0000", "购物车编号不存在");
        }
        return cartBO.removeCart(code);
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#queryCartPage(int, int, com.xnjr.mall.domain.Cart)
     */
    @Override
    public Paginable<Cart> queryCartPage(int start, int limit, Cart condition) {
        return cartBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#queryCartList(com.xnjr.mall.domain.Cart)
     */
    @Override
    public List<Cart> queryCartList(Cart condition) {
        return cartBO.queryCartList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#getCart(java.lang.String)
     */
    @Override
    public Cart getCart(String code) {
        return cartBO.getCart(code);
    }
}

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

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ICartAO;
import com.xnjr.mall.bo.IBuyGuideBO;
import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.dto.res.XN805901Res;
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

    @Autowired
    IBuyGuideBO buyGuideBO;

    @Autowired
    IModelBO modelBO;

    @Autowired
    IUserBO userBO;

    /** 
     * @see com.xnjr.mall.ao.ICartAO#addCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public String addCart(Cart data) {
        String code = null;
        if (!modelBO.isModelExist(data.getModelCode())) {
            throw new BizException("xn0000", "型号编号不存在");
        }
        Cart cart = cartBO.getCart(data.getUserId(), data.getModelCode());
        if (cart != null) {
            code = cart.getCode();
            data.setCode(code);
            int quantity = cart.getQuantity() + data.getQuantity();
            data.setQuantity(quantity);
            cartBO.refreshCart(data);
        } else {
            code = cartBO.saveCart(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#editCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public int editCart(Cart data) {
        if (!cartBO.isCartExist(data.getCode())) {
            throw new BizException("xn0000", "购物车编号不存在");
        }
        if (!modelBO.isModelExist(data.getModelCode())) {
            throw new BizException("xn0000", "型号编号不存在");
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
     * @see com.xnjr.mall.ao.ICartAO#dropCartList(java.util.List)
     */
    @Override
    @Transactional
    public int dropCartList(List<String> cartCodeList) {
        int count = 0;
        for (String cartCode : cartCodeList) {
            count = cartBO.removeCart(cartCode);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#queryCartPage(int, int, com.xnjr.mall.domain.Cart)
     */
    @Override
    public Paginable<Cart> queryCartPage(int start, int limit, Cart condition) {
        // 获取用户信息
        String userId = condition.getUserId();
        XN805901Res user = userBO.getRemoteUser(userId, userId);
        Paginable<Cart> page = cartBO.getPaginable(start, limit, condition);
        if (page != null && page.getList() != null) {
            for (Cart cart : page.getList()) {
                Long salePrice = buyGuideBO.getBuyGuidePrice(
                    cart.getModelCode(), user.getLevel());
                cart.setSalePrice(salePrice);
            }
        }
        return page;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#queryCartList(com.xnjr.mall.domain.Cart)
     */
    @Override
    public List<Cart> queryCartList(Cart condition) {
        // 获取用户信息
        String userId = condition.getUserId();
        XN805901Res user = userBO.getRemoteUser(userId, userId);
        List<Cart> list = cartBO.queryCartList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            for (Cart cart : list) {
                Long salePrice = buyGuideBO.getBuyGuidePrice(
                    condition.getModelCode(), user.getLevel());
                cart.setSalePrice(salePrice);
            }
        }
        return list;
    }

    /** 
     * @see com.xnjr.mall.ao.ICartAO#getCart(java.lang.String)
     */
    @Override
    public Cart getCart(String code) {
        Cart cart = cartBO.getCart(code);
        // 获取用户信息
        String userId = cart.getUserId();
        XN805901Res user = userBO.getRemoteUser(userId, userId);
        // 获取价格
        Long salePrice = buyGuideBO.getBuyGuidePrice(cart.getModelCode(),
            user.getLevel());
        cart.setSalePrice(salePrice);
        return cart;
    }
}

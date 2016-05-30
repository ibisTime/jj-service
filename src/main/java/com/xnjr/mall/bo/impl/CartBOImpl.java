/**
 * @Title CartBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月24日 下午9:41:51 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ICartBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.ICartDAO;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 下午9:41:51 
 * @history:
 */
@Component
public class CartBOImpl extends PaginableBOImpl<Cart> implements ICartBO {

    @Autowired
    private ICartDAO cartDAO;

    /** 
     * @see com.xnjr.mall.bo.ICartBO#isCartExist(java.lang.String)
     */
    @Override
    public boolean isCartExist(String code) {
        Cart condition = new Cart();
        condition.setCode(code);
        if (cartDAO.selectTotalCount(condition) > 0) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.ICartBO#isCartExist(java.lang.String, java.lang.String)
     */
    @Override
    public Cart getCart(String userId, String modelCode) {
        Cart result = new Cart();
        Cart condition = new Cart();
        condition.setUserId(userId);
        condition.setModelCode(modelCode);
        List<Cart> list = cartDAO.selectList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            result = list.get(0);
        }
        return result;
    }

    /** 
     * @see com.xnjr.mall.bo.ICartBO#saveCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public String saveCart(Cart data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.CT.getCode());
            data.setCode(code);
            cartDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.ICartBO#removeCart(java.lang.String)
     */
    @Override
    public int removeCart(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Cart data = new Cart();
            data.setCode(code);
            count = cartDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ICartBO#refreshCart(com.xnjr.mall.domain.Cart)
     */
    @Override
    public int refreshCart(Cart data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = cartDAO.update(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ICartBO#queryCartList(com.xnjr.mall.domain.Cart)
     */
    @Override
    public List<Cart> queryCartList(Cart condition) {
        return cartDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.ICartBO#getCart(java.lang.String)
     */
    @Override
    public Cart getCart(String code) {
        Cart data = null;
        if (StringUtils.isNotBlank(code)) {
            Cart condition = new Cart();
            condition.setCode(code);
            data = cartDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "购物车编号不存在");
            }
        }
        return data;
    }
}

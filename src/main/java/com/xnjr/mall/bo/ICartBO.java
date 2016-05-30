/**
 * @Title ICart.java 
 * @Package com.xnjr.mall 
 * @Description 
 * @author xieyj  
 * @date 2016年5月24日 上午8:23:54 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Cart;

/** 
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:23:54 
 * @history:
 */
public interface ICartBO extends IPaginableBO<Cart> {

    /**
     * 判断购物车是否已经存在
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:35:26 xieyj
     * @history:
     */
    public boolean isCartExist(String code);

    /**
     * 根据用户编号和型号编号获取购物车详情
     * @param userId
     * @param modelCode
     * @return 
     * @create: 2016年5月30日 下午1:34:12 xieyj
     * @history:
     */
    public Cart getCart(String userId, String modelCode);

    /**
     * 保存购物车
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:35:33 xieyj
     * @history:
     */
    public String saveCart(Cart data);

    /**
     * 删除购物车
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:35:52 xieyj
     * @history:
     */
    public int removeCart(String code);

    /**
     * 更新购物车
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:36:04 xieyj
     * @history:
     */
    public int refreshCart(Cart data);

    /**
     * 查询购物车列表
     * @param data
     * @return 
     * @create: 2016年5月24日 下午9:36:15 xieyj
     * @history:
     */
    public List<Cart> queryCartList(Cart data);

    /**
     * 查询购物车详情
     * @param code
     * @return 
     * @create: 2016年5月24日 下午9:36:24 xieyj
     * @history:
     */
    public Cart getCart(String code);
}

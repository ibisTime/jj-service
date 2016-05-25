package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Cart;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface ICartAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 新增
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:02 xieyj
     * @history:
     */
    public String addCart(Cart data);

    /**
     * 删除
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:25 xieyj
     * @history:
     */
    public int dropCart(String code);

    /**
     * 修改
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:25 xieyj
     * @history:
     */
    public int editCart(Cart data);

    /**
     * 分页查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public Paginable<Cart> queryCartPage(int start, int limit, Cart condition);

    /**
     * 列表查询
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public List<Cart> queryCartList(Cart condition);

    /**
     * 详情
     * @param code
     * @return 
     * @create: 2016年5月24日 上午9:07:33 xieyj
     * @history:
     */
    public Cart getCart(String code);

}

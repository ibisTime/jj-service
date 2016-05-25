package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Cart;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:20:34 
 * @history:
 */
public interface ICartDAO extends IBaseDAO<Cart> {
    String NAMESPACE = ICartDAO.class.getName().concat(".");

    /**
     * 更新
     * @param data
     * @return 
     * @create: 2015年8月26日 下午11:27:59 xieyj
     * @history:
     */
    public int update(Cart data);
}

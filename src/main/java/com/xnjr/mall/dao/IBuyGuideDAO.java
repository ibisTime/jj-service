package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.BuyGuide;

/**
 * @author: xieyj 
 * @since: 2016年5月24日 上午8:20:34 
 * @history:
 */
public interface IBuyGuideDAO extends IBaseDAO<BuyGuide> {
    String NAMESPACE = IBuyGuideDAO.class.getName().concat(".");

    /**
     * 更新
     * @param data
     * @return 
     * @create: 2015年8月26日 下午11:27:59 xieyj
     * @history:
     */
    public int update(BuyGuide data);

    public int updateStatus(BuyGuide data);
}

package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.GoodsOrder;

public interface IGoodsOrderDAO extends IBaseDAO<GoodsOrder> {
    String NAMESPACE = IGoodsOrderDAO.class.getName().concat(".");

    /** 
     * 审批货品订单
     * @param data
     * @return 
     * @create: 2016年7月21日 上午9:41:51 zuixian
     * @history: 
     */
    public int updateGoodsOrderApprove(GoodsOrder data);
}

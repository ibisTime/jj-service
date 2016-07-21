package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.enums.EBoolean;

/** 
 * @author: zuixian 
 * @since: 2016年7月21日 上午11:07:24 
 * @history:
 */
public interface IGoodsOrderAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    /** 
     * 申请货品订单
     * @param data
     * @return 
     * @create: 2016年7月21日 上午11:08:25 zuixian
     * @history: 
     */
    public String doApplyGoodsOrder(GoodsOrder data);

    /** 
     * 审批货品订单
     * @param code
     * @param approveUser
     * @param approveNote
     * @param eboolean
     * @return 
     * @create: 2016年7月21日 上午11:16:25 zuixian
     * @history: 
     */
    public int approveGoodsOrder(String code, String approveUser,
            String approveNote, EBoolean eboolean);

    /** 
     * 查询货品订单详情
     * @param code
     * @return 
     * @create: 2016年7月21日 上午11:22:11 zuixian
     * @history: 
     */
    public GoodsOrder getGoodsOrder(String code);

    /** 
     * 查询货品订单列表
     * @param condition
     * @return 
     * @create: 2016年7月21日 上午11:18:01 zuixian
     * @history: 
     */
    public List<GoodsOrder> queryGoodsOrderList(GoodsOrder condition);

    /** 
     * 查询货品订单分页
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年7月21日 上午11:18:46 zuixian
     * @history: 
     */
    public Paginable<GoodsOrder> queryGoodsOrderPage(int start, int limit,
            GoodsOrder condition);
}

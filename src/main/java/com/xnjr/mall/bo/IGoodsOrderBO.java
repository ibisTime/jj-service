package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.enums.ENormalStatus;

/** 
 * @author: zuixian 
 * @since: 2016年7月21日 上午9:57:03 
 * @history:
 */
public interface IGoodsOrderBO extends IPaginableBO<GoodsOrder> {

    /** 
     * 判断是否存在
     * @param code
     * @return 
     * @create: 2016年7月21日 上午9:56:51 zuixian
     * @history: 
     */
    public boolean isInvoiceExist(String code);

    /** 
     * 保存货品订单
     * @param data
     * @return 
     * @create: 2016年7月21日 上午9:58:14 zuixian
     * @history: 
     */
    public String saveGoodsOrder(GoodsOrder data);

    /** 
     * 审批货品订单
     * @param data
     * @return 
     * @create: 2016年7月21日 上午10:00:51 zuixian
     * @history: 
     */
    public int approveGoodsOrder(String code, String approveUser,
            String approveNote, ENormalStatus status);

    /** 
     * 获取货品订单详情
     * @param code
     * @return 
     * @create: 2016年7月21日 上午10:01:31 zuixian
     * @history: 
     */
    public GoodsOrder getGoodsOrder(String code);

    /** 
     * 查询货品订单列表
     * @param data
     * @return 
     * @create: 2016年7月21日 上午10:02:35 zuixian
     * @history: 
     */
    public List<GoodsOrder> queryGoodsOrderList(GoodsOrder data);
}

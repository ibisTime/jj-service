/**
 * @Title IHLOrderBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:20:06 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.HLOrder;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:20:06 
 * @history:
 */
public interface IHLOrderBO extends IPaginableBO<HLOrder> {
    /**
     * 
     * @param accountNumber
     * @param type
     * @param amount
     * @param updater
     * @param remark
     * @return 
     * @create: 2016年1月17日 下午2:50:09 myb858
     * @history:
     */
    public String saveHLOrder(String accountNumber, String type, Long amount,
            String updater, String remark);

    /**
     * 
     * @param hlNo
     * @param updater
     * @param approveResult
     * @param remark
     * @return 
     * @create: 2015-5-5 下午1:41:25 miyb
     * @history:
     */
    public int refreshApproveOrder(String hlNo, String updater,
            String approveResult, String remark);

    /**
     * 获取单条订单
     * @param hlNo
     * @return 
     * @create: 2015-5-5 下午1:03:42 miyb
     * @history:
     */
    public HLOrder getHLOrder(String hlNo);

    /**
     * 获取订单列表
     * @param condition
     * @return 
     * @create: 2015-5-5 下午1:04:05 miyb
     * @history:
     */
    public List<HLOrder> queryHLOrderList(HLOrder condition);
}

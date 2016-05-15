/**
 * @Title IHLOrderAO.java 
 * @Package com.ibis.account.ao 
 * @Description 
 * @author miyb  
 * @date 2015-3-17 下午7:24:27 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.HLOrder;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: miyb 
 * @since: 2015-3-17 下午7:24:27 
 * @history:
 */
@ServiceModule
public interface IHLOrderAO {
    String DEFAULT_ORDER_COLUMN = "hl_no";

    /** 
     * 红冲蓝补申请
     * @param accountNumber
     * @param amount
     * @param applyUser
     * @param applyNote
     * @return 
     * @create: 2015-5-8 上午10:27:04 miyb
     * @history: 
     */
    public String doBalance(String accountNumber, Long amount, String updater,
            String remark);

    /**
     * 红冲蓝补审批
     * @param hlNo
     * @param approveUser
     * @param approveResult
     * @param approveNote 
     * @create: 2016年1月16日 下午7:29:28 myb858
     * @history:
     */
    public void doApprove(String hlNo, String updater, String approveResult,
            String remark);

    /** 
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015-5-10 上午10:44:02 miyb
     * @history: 
     */
    public Paginable<HLOrder> queryHLOrderPage(int start, int limit,
            HLOrder condition);

    /**
     * 红冲蓝补记录查询
     * @param condition
     * @return 
     * @create: 2015年12月12日 下午5:12:28 haiqingzheng
     * @history:
     */
    public List<HLOrder> queryHLOrderList(HLOrder condition);

}

package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDWithdraw;
import com.xnjr.mall.spring.ServiceModule;

/**
 * 
 * @author:duanjiewen
 * @since: 2016年4月27日 下午3:20:28 
 * @history:
 */
@ServiceModule
public interface IFDWithdrawAO {

    String DEFAULT_ORDER_COLUMN = "qx_no";

    /**
     * 管理端取现
     * @param data
     * @return 
     * @create: 2016年4月27日 下午3:36:44 duanjiewen
     * @history:
     */
    public String doWithdrawOSS(Long amount, String towho, String accountNumber);

    /**
     * 审批线下取现订单
     * @param withdrawNo
     * @param approveUser
     * @param approveResult
     * @param approveNote 
     * @create: 2016年4月27日 下午5:50:43 Gejin
     * @history:
     */
    public void doApproveWithdraw(String qxNo, String approveUser,
            String approveResult, String approveNote);

    /**
     * 支付取现订单
     * @param qxNo
     * @param payUser
     * @param payResult
     * @param remark
     * @param payNo
     * @param payFree
     * @param workDate 
     * @create: 2016年4月27日 下午7:37:29 Gejin
     * @history:
     */
    public void doPayWithdraw(String qxNo, String payUser, String payResult,
            String payNote, String payNo, Long payFree, String workDate);

    /**
     * 分页查询取现订单
     * @param condition
     * @return 
     * @create: 2016年4月27日 下午7:56:16 Gejin
     * @history:
     */
    public Paginable<FDWithdraw> queryWithdrawPage(int start, int limit,
            FDWithdraw condition);
}

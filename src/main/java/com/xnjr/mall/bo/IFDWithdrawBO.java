package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDWithdraw;

public interface IFDWithdrawBO extends IPaginableBO<FDWithdraw> {

    /**
     * 线下申请取现订单
     * @param data
     * @return 
     * @create: 2016年4月27日 上午10:53:17 duanjiewen
     * @history:
     */
    public String saveWithdraw(Long amount, String towho, String accountNumber);

    /**
     * 审批线下取现订单
     * @param qxNo
     * @param approveUser
     * @param remark
     * @return 
     * @create: 2016年4月27日 下午5:42:53 Gejin
     * @history:
     */
    public int refreshApproveOrder(String qxNo, String approveUser,
            String approveResult, String remark);

    /**
     * 获取单条取现订单
     * @param qxNo
     * @return 
     * @create: 2016年4月27日 下午7:17:28 Gejin
     * @history:
     */
    public FDWithdraw getWithdraw(String qxNo);

    /**
     * 支付取现订单
     * @param qxNo
     * @param payUser
     * @param payResult
     * @param payNote
     * @param payNo
     * @param payFee
     * @param workDate
     * @return 
     * @create: 2016年4月27日 下午7:32:50 Gejin
     * @history:
     */
    public int refreshPayOrder(String qxNo, String payUser, String payResult,
            String payNote, String payNo, Long payFee, String workDate);

    /**
     * 查询取现订单列表
     * @param condition
     * @return 
     * @create: 2016年4月27日 下午7:54:44 Gejin
     * @history:
     */
    public List<FDWithdraw> queryWithdrawList(FDWithdraw condition);
}

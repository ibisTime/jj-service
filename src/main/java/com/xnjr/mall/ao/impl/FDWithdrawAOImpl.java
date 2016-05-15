package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IFDWithdrawAO;
import com.xnjr.mall.bo.IFDBankCardBO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDCompanyCardBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDWithdrawBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.core.CalculationUtil;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.domain.FDWithdraw;
import com.xnjr.mall.enums.EBizType;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.enums.EWithdrawStatus;
import com.xnjr.mall.exception.BizException;

@Service
public class FDWithdrawAOImpl implements IFDWithdrawAO {

    @Autowired
    IFDWithdrawBO fdWithdrawBO;

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    IFDBankCardBO fdBankCardBO;

    @Autowired
    IFDCompanyCardBO fdCompanyCardBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Override
    @Transactional
    public String doWithdrawOSS(Long amount, String towho, String accountNumber) {
        String orderNo = fdWithdrawBO
            .saveWithdraw(amount, towho, accountNumber);
        if (accountNumber.startsWith(EPrefixOrderNo.individual.getCode())) {
            fdUserAccountBO.freezeAmount(accountNumber, amount, EBizType.AJ_QX,
                orderNo);
        } else if (accountNumber.startsWith(EPrefixOrderNo.company.getCode())) {
            fdCompanyAccountBO.freezeAmount(accountNumber, amount,
                EBizType.AJ_QX, orderNo);
        } else {
            throw new BizException("xnfd0000", "账户编号格式不正确");
        }
        return orderNo;
    }

    @Override
    public void doApproveWithdraw(String qxNo, String approveUser,
            String approveResult, String approveNote) {
        FDWithdraw fdWithdraw = fdWithdrawBO.getWithdraw(qxNo);
        if (fdWithdraw == null) {
            throw new BizException("xnfd0053", "无对应取现订单");
        }
        if (!EWithdrawStatus.todoAPPROVE.getCode().equalsIgnoreCase(
            fdWithdraw.getStatus())) {
            throw new BizException("xnfd0053", "订单不处于待审批状态");
        }
        // 审核不通过，解冻金额
        if (EBoolean.NO.getCode().equals(approveResult)) {
            String accountNumber = fdWithdraw.getAccountNumber();
            if (accountNumber.startsWith(EPrefixOrderNo.individual.getCode())) {
                fdUserAccountBO.unfreezeAmount(accountNumber,
                    fdWithdraw.getAmount(), EBizType.AJ_JD, qxNo, true);
            } else if (accountNumber.startsWith(EPrefixOrderNo.company
                .getCode())) {
                fdCompanyAccountBO.unfreezeAmount(accountNumber,
                    fdWithdraw.getAmount(), EBizType.AJ_JD, qxNo, true);
            } else {
                throw new BizException("xnfd0000", "账户编号格式不正确");
            }
        }
        fdWithdrawBO.refreshApproveOrder(qxNo, approveUser, approveResult,
            approveNote);
    }

    @Override
    @Transactional
    public void doPayWithdraw(String qxNo, String payUser, String payResult,
            String payNote, String payNo, Long payFree, String workDate) {
        FDWithdraw fdWithdraw = fdWithdrawBO.getWithdraw(qxNo);
        if (fdWithdraw == null) {
            throw new BizException("xnfd0000", "无对应取现订单");
        }
        if (!EWithdrawStatus.APPROVE_YES.getCode().equalsIgnoreCase(
            fdWithdraw.getStatus())) {
            throw new BizException("xnfd0000", "订单不处于待支付状态");
        }
        fdWithdrawBO.refreshPayOrder(qxNo, payUser, payResult, payNote, payNo,
            payFree, workDate);

        // 刷新银行卡状态
        // bankCardBO.refreshStatus(cqOrder.getBankCode(),
        // cqOrder.getBankcardNo(), EBankCardStatus.CONFIRM_YES);
        // 发送短信
        if (fdWithdraw.getAccountNumber().startsWith(
            EPrefixOrderNo.company.getCode())) {
            // FDCompanyAccount account =
            // fdCompanyAccountBO.getAccount(fdWithdraw
            // .getAccountNumber());
            // User user = userBO.getUser(account.getUserId());
            // String mobile = user.getMobile();
            if (EBoolean.YES.getCode().equalsIgnoreCase(payResult)) {
                fdCompanyAccountBO.unfreezeAmount(
                    fdWithdraw.getAccountNumber(), fdWithdraw.getAmount(),
                    EBizType.AJ_JD, fdWithdraw.getQxNo(), false);
                // smsOutBO.sendSmsOut(mobile,
                // "尊敬的" + PhoneUtil.hideMobile(mobile) + "用户，您提交的"
                // + CalculationUtil.divi(cqOrder.getAmount())
                // + "取现申请，支付成功。资金已转入你绑定的银行卡账户中，请注意核对。",
                // ESmsBizType.Withdraw_Yes.getCode(),
                // ESmsBizType.Withdraw_Yes.getValue());
            } else {
                fdCompanyAccountBO.unfreezeAmount(
                    fdWithdraw.getAccountNumber(), fdWithdraw.getAmount(),
                    EBizType.AJ_JD, fdWithdraw.getQxNo(), true);
                // smsOutBO.sendSmsOut(mobile,
                // "尊敬的" + PhoneUtil.hideMobile(mobile) + "用户,您提交的"
                // + CalculationUtil.divi(cqOrder.getAmount())
                // + "取现申请，支付失败，原因：" + payNote
                // + "，如有疑问，请联系客服：400-0008-139。",
                // ESmsBizType.Withdraw_No.getCode(),
                // ESmsBizType.Withdraw_No.getValue());
            }
        } else if (fdWithdraw.getAccountNumber().startsWith(
            EPrefixOrderNo.individual.getCode())) {
            FDUserAccount account = fdUserAccountBO.getAccount(fdWithdraw
                .getAccountNumber());
            FDUser user = fdUserBO.getUser(account.getUserId());
            String mobile = user.getMobile();
            if (EBoolean.YES.getCode().equalsIgnoreCase(payResult)) {
                fdUserAccountBO.unfreezeAmount(fdWithdraw.getAccountNumber(),
                    fdWithdraw.getAmount(), EBizType.AJ_JD,
                    fdWithdraw.getQxNo(), false);
                smsOutBO.sendSmsOut(mobile,
                    "尊敬的" + PhoneUtil.hideMobile(mobile) + "用户，您提交的"
                            + CalculationUtil.divi(fdWithdraw.getAmount())
                            + "取现申请，支付成功。资金已转入你绑定的银行卡账户中，请注意核对。",
                    ESmsBizType.Withdraw_Yes.getCode(),
                    ESmsBizType.Withdraw_Yes.getValue());
            } else {
                fdUserAccountBO.unfreezeAmount(fdWithdraw.getAccountNumber(),
                    fdWithdraw.getAmount(), EBizType.AJ_JD,
                    fdWithdraw.getQxNo(), true);
                smsOutBO.sendSmsOut(mobile,
                    "尊敬的" + PhoneUtil.hideMobile(mobile) + "用户,您提交的"
                            + CalculationUtil.divi(fdWithdraw.getAmount())
                            + "取现申请，支付失败，原因：" + payNote
                            + "，如有疑问，请联系客服：400-0008-139。",
                    ESmsBizType.Withdraw_No.getCode(),
                    ESmsBizType.Withdraw_No.getValue());
            }
        }
    }

    @Override
    public Paginable<FDWithdraw> queryWithdrawPage(int start, int limit,
            FDWithdraw condition) {
        return fdWithdrawBO.getPaginable(start, limit, condition);
    }

}

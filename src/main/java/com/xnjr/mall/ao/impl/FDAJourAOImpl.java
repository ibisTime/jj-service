package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.bo.IFDAJourBO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.IHLOrderBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyAccount;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.domain.HLOrder;
import com.xnjr.mall.enums.EAccountJourStatus;
import com.xnjr.mall.enums.EBizType;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.ECheckJourType;
import com.xnjr.mall.enums.EDirection;
import com.xnjr.mall.enums.EHLOrderType;
import com.xnjr.mall.enums.EOrderStatus;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.exception.BizException;

/**
 * @author: xieyj 
 * @since: 2016年4月23日 下午5:04:18 
 * @history:
 */
@Service
public class FDAJourAOImpl implements IFDAJourAO {
    @Autowired
    IFDAJourBO fdAJourBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    IHLOrderBO hlOrderBO;

    @Override
    public Paginable<FDAccountJour> queryAccountJourPage(int start, int limit,
            FDAccountJour condition) {
        return fdAJourBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDAJourAO#queryFrontAccountJourPage(int, int, java.lang.String, com.xnjr.mall.domain.FDAccountJour)
     */
    @Override
    public Paginable<FDAccountJour> queryFrontAccountJourPage(int start,
            int limit, String userId, FDAccountJour condition) {
        List<String> accountNumberList = new ArrayList<String>();
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户不存在");
        }
        if (fdUser.getIndividualCode() != null) {
            FDUserAccount fdUserAccount = fdUserAccountBO
                .getAccountByUserId(userId);
            accountNumberList.add(fdUserAccount.getAccountNumber());
        }
        List<FDCompany> companyList = fdUserCompanyBO
            .queryConfirmCompanyByUserId(userId);
        for (FDCompany fdCompany : companyList) {
            FDCompanyAccount fdCompanyAccount = fdCompanyAccountBO
                .getAccountByCompanyCode(fdCompany.getCode());
            accountNumberList.add(fdCompanyAccount.getAccountNumber());
        }
        condition.setAccountNumberList(accountNumberList);
        return fdAJourBO.getPaginable(start, limit, condition);
    }

    @Override
    public void doCheckJour(Long ajNo, String type, String checkUser,
            Long amount, String remark) {
        if (ECheckJourType.fd.getCode().equals(type)) {
            FDAccountJour aJour = fdAJourBO.getAccountJour(ajNo);
            if (aJour == null) {
                throw new BizException("xn702514", "无对应交易流水");
            }
            if (!EAccountJourStatus.todoCheck.getCode().equalsIgnoreCase(
                aJour.getStatus())) {
                throw new BizException("xn702514", "账户流水不处于待对账状态");
            }
            if (amount != 0) {// 账不平
                fdAJourBO.doCheckAccount(ajNo, checkUser, EBoolean.NO);
                hlOrderBO.saveHLOrder(aJour.getAccountNumber(),
                    EHLOrderType.TZ.getCode(), amount, checkUser, remark);
            } else {// 账是平的
                fdAJourBO.doCheckAccount(ajNo, checkUser, EBoolean.YES);
            }
        } else {
            // 其他方对账
        }
    }

    @Override
    public void doApproveCheckJour(String hlNo, String updater,
            String approveResult, String remark) {
        HLOrder hlOrder = hlOrderBO.getHLOrder(hlNo);
        if (hlOrder == null) {
            throw new BizException("xn702514", "无对应充取订单");
        }
        if (!EOrderStatus.todoAPPROVE.getCode().equalsIgnoreCase(
            hlOrder.getStatus())) {
            throw new BizException("xn702514", "订单不处于待审批状态");
        }
        hlOrderBO.refreshApproveOrder(hlNo, updater, approveResult, remark);
        if (EDirection.PLUS.getCode().equalsIgnoreCase(// 蓝补
            hlOrder.getDirection())) {
            if (EBoolean.YES.getCode().equalsIgnoreCase(approveResult)) { // 资金变动
                if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.individual.getCode())) {
                    fdUserAccountBO.refreshAmountWithoutCheck(
                        hlOrder.getAccountNumber(), hlOrder.getAmount(),
                        EBizType.AJ_LB.getCode(), hlOrder.getHlNo());
                } else if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.company.getCode())) {
                    fdCompanyAccountBO.refreshAmountWithoutCheck(
                        hlOrder.getAccountNumber(), hlOrder.getAmount(),
                        EBizType.AJ_LB.getCode(), hlOrder.getHlNo());
                }
            }
        } else {
            if (EBoolean.YES.getCode().equalsIgnoreCase(approveResult)) { // 资金变动
                if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.individual.getCode())) {
                    fdUserAccountBO.refreshAmountWithoutCheck(
                        hlOrder.getAccountNumber(), -hlOrder.getAmount(),
                        EBizType.AJ_HC.getCode(), hlOrder.getHlNo());
                } else if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.company.getCode())) {
                    fdCompanyAccountBO.refreshAmountWithoutCheck(
                        hlOrder.getAccountNumber(), -hlOrder.getAmount(),
                        EBizType.AJ_HC.getCode(), hlOrder.getHlNo());
                }
            }
        }
    }
}

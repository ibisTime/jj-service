/**
 * @Title HLOrderAOImpl.java 
 * @Package com.ibis.account.ao.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-17 下午9:34:19 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IHLOrderAO;
import com.xnjr.mall.bo.IFDCompanyAccountBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IHLOrderBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.HLOrder;
import com.xnjr.mall.enums.EBizType;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EDirection;
import com.xnjr.mall.enums.EHLOrderType;
import com.xnjr.mall.enums.EOrderStatus;
import com.xnjr.mall.enums.EPrefixOrderNo;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-17 下午9:34:19 
 * @history:
 */
@Service
public class HLOrderAOImpl implements IHLOrderAO {
    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDCompanyAccountBO fdCompanyAccountBO;

    @Autowired
    IFDUserAccountBO fdUserAccountBO;

    @Autowired
    IHLOrderBO hlOrderBO;

    @Autowired
    ISmsOutBO smsOutBO;

    /** 
     * @see com.ibis.account.ao.IHLOrderAO#doBalance(java.lang.String, java.lang.Long, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public String doBalance(String accountNumber, Long amount, String updater,
            String remark) {
        if (!accountNumber.startsWith(EPrefixOrderNo.company.getCode())
                && !accountNumber.startsWith(EPrefixOrderNo.individual
                    .getCode())) {
            throw new BizException("xn000000", "账户编号格式有误，请输入个人或企业账户编号");
        }
        // 账户编号正确性检测
        if (accountNumber.startsWith(EPrefixOrderNo.company.getCode())) {
            fdCompanyAccountBO.getAccount(accountNumber);
        } else if (accountNumber
            .startsWith(EPrefixOrderNo.individual.getCode())) {
            fdUserAccountBO.getAccount(accountNumber);
        }
        return hlOrderBO.saveHLOrder(accountNumber, EHLOrderType.RG.getCode(),
            amount, updater, remark);
    }

    @Override
    @Transactional
    public void doApprove(String hlNo, String updater, String approveResult,
            String remark) {
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
                    EPrefixOrderNo.company.getCode())) {
                    fdCompanyAccountBO.refreshAmount(
                        hlOrder.getAccountNumber(), hlOrder.getAmount(),
                        EBizType.AJ_LB.getCode(), hlOrder.getHlNo(),
                        EBizType.AJ_LB.getValue());
                } else if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.individual.getCode())) {
                    fdUserAccountBO.refreshAmount(hlOrder.getAccountNumber(),
                        hlOrder.getAmount(), EBizType.AJ_LB.getCode(),
                        hlOrder.getHlNo(), EBizType.AJ_LB.getValue());
                }
            }
        } else {
            if (EBoolean.YES.getCode().equalsIgnoreCase(approveResult)) { // 资金变动
                if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.company.getCode())) {
                    fdCompanyAccountBO.refreshAmount(
                        hlOrder.getAccountNumber(), -hlOrder.getAmount(),
                        EBizType.AJ_HC.getCode(), hlOrder.getHlNo(),
                        EBizType.AJ_HC.getValue());
                } else if (hlOrder.getAccountNumber().startsWith(
                    EPrefixOrderNo.individual.getCode())) {
                    fdUserAccountBO.refreshAmount(hlOrder.getAccountNumber(),
                        -hlOrder.getAmount(), EBizType.AJ_HC.getCode(),
                        hlOrder.getHlNo(), EBizType.AJ_HC.getValue());
                }
            }
        }

    }

    /** 
     * @see com.ibis.account.ao.IHLOrderAO#queryHLOrderPage(int, int, com.ibis.account.domain.HLOrder)
     */
    @Override
    public Paginable<HLOrder> queryHLOrderPage(int start, int limit,
            HLOrder condition) {
        return hlOrderBO.getPaginable(start, limit, condition);
    }

    /**
     * @see com.std.account.ao.IHLOrderAO#queryHLOrderPage(com.std.account.domain.HLOrder)
     */
    @Override
    public List<HLOrder> queryHLOrderList(HLOrder condition) {
        return hlOrderBO.queryHLOrderList(condition);
    }

}

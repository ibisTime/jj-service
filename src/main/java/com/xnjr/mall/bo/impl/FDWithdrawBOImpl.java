package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDWithdrawBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IFDWithdrawDAO;
import com.xnjr.mall.domain.FDWithdraw;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EWithdrawStatus;

@Component
public class FDWithdrawBOImpl extends PaginableBOImpl<FDWithdraw> implements
        IFDWithdrawBO {
    @Autowired
    private IFDWithdrawDAO fdWithdrawDAO;

    @Override
    public String saveWithdraw(Long amount, String towho, String accountNumber) {
        String qxNo = null;
        if (StringUtils.isNotBlank(accountNumber) && amount != 0
                && StringUtils.isNotBlank(towho)) {
            FDWithdraw data = new FDWithdraw();
            qxNo = OrderNoGenerater.generateM("FD");
            data.setQxNo(qxNo);
            data.setStatus(EWithdrawStatus.todoAPPROVE.getCode());
            data.setAmount(amount);
            data.setTowho(towho);
            data.setCreateDatetime(new Date());
            data.setAccountNumber(accountNumber);
            fdWithdrawDAO.insert(data);
        }
        return qxNo;
    }

    @Override
    public int refreshApproveOrder(String qxNo, String approveUser,
            String approveResult, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(qxNo) && StringUtils.isNotBlank(approveUser)
                && StringUtils.isNotBlank(remark)) {
            FDWithdraw data = new FDWithdraw();
            data.setQxNo(qxNo);
            if (EBoolean.YES.getCode().equalsIgnoreCase(approveResult)) {
                data.setStatus(EWithdrawStatus.APPROVE_YES.getCode());
            } else {
                data.setStatus(EWithdrawStatus.APPROVE_NO.getCode());
            }
            data.setApproveUser(approveUser);
            data.setApproveDatetime(new Date());
            data.setRemark(remark);
            count = fdWithdrawDAO.updateApproveOrder(data);
        }
        return count;
    }

    @Override
    public FDWithdraw getWithdraw(String qxNo) {
        FDWithdraw data = null;
        if (StringUtils.isNotBlank(qxNo)) {
            FDWithdraw condition = new FDWithdraw();
            condition.setQxNo(qxNo);
            data = fdWithdrawDAO.select(condition);
        }
        return data;
    }

    @Override
    public int refreshPayOrder(String qxNo, String payUser, String payResult,
            String payNote, String payNo, Long payFee, String workDate) {
        int count = 0;
        if (StringUtils.isNotBlank(qxNo) && StringUtils.isNotBlank(payUser)
                && StringUtils.isNotBlank(payResult)) {
            FDWithdraw data = new FDWithdraw();
            data.setQxNo(qxNo);
            if (EBoolean.YES.getCode().equalsIgnoreCase(payResult)) {
                data.setStatus(EWithdrawStatus.PAY_YES.getCode());
            } else {
                data.setStatus(EWithdrawStatus.PAY_NO.getCode());
            }
            data.setPayFee(payFee);
            data.setPayNo(payNo);
            data.setPayUser(payUser);
            data.setPayDatetime(new Date());
            data.setWorkDate(workDate);
            count = fdWithdrawDAO.updatePayOrder(data);
        }
        return count;
    }

    @Override
    public List<FDWithdraw> queryWithdrawList(FDWithdraw condition) {
        return fdWithdrawDAO.selectList(condition);
    }
}

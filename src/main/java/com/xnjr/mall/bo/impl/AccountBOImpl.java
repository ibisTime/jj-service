package com.xnjr.mall.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.dto.req.XN802011Req;
import com.xnjr.mall.dto.req.XN802112Req;
import com.xnjr.mall.dto.req.XN802310Req;
import com.xnjr.mall.dto.res.XN802011Res;
import com.xnjr.mall.dto.res.XN802112Res;
import com.xnjr.mall.dto.res.XN802310Res;
import com.xnjr.mall.http.BizConnecter;
import com.xnjr.mall.http.JsonUtils;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#doChargeOfflineWithdrawApp(java.lang.String, java.lang.Long, java.lang.String, java.lang.String)
     */
    @Override
    public String doChargeOfflineWithoutApp(String accountNumber, Long amount,
            String fromType, String fromCode, String pdf, String approveUser,
            String approveNote) {
        XN802112Req req = new XN802112Req();
        req.setAccountNumber(accountNumber);
        req.setAmount(String.valueOf(amount));
        req.setFromType(fromType);
        req.setFromCode(fromCode);
        req.setPdf(pdf);
        req.setApproveUser(approveUser);
        req.setApproveNote(approveNote);
        XN802112Res res = BizConnecter.getBizData("802112",
            JsonUtils.object2Json(req), XN802112Res.class);
        return res.getCqNo();
    }

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#doTransfer(java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String)
     */
    @Override
    public String doTransferOss(String accountNumber, String direction,
            Long amount, Long fee, String remark) {
        XN802310Req req = new XN802310Req();
        req.setAccountNumber(accountNumber);
        req.setDirection(direction);
        req.setAmount(String.valueOf(amount));
        req.setFee(String.valueOf(fee));
        req.setRemark(remark);
        XN802310Res res = BizConnecter.getBizData("802310",
            JsonUtils.object2Json(req), XN802310Res.class);
        return res.getCode();
    }

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#getAccountByUserId(java.lang.String)
     */
    @Override
    public XN802011Res getAccountByUserId(String userId) {
        XN802011Req req = new XN802011Req();
        req.setUserId(userId);
        return BizConnecter.getBizData("802011", JsonUtils.object2Json(req),
            XN802011Res.class);
    }
}

package com.xnjr.mall.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.dto.req.XN802013Req;
import com.xnjr.mall.dto.req.XN802112Req;
import com.xnjr.mall.dto.req.XN802120Req;
import com.xnjr.mall.dto.req.XN802122Req;
import com.xnjr.mall.dto.req.XN802310Req;
import com.xnjr.mall.dto.req.XN802313Req;
import com.xnjr.mall.dto.res.XN802012Res;
import com.xnjr.mall.dto.res.XN802013Res;
import com.xnjr.mall.dto.res.XN802112Res;
import com.xnjr.mall.dto.res.XN802122Res;
import com.xnjr.mall.dto.res.XN802310Res;
import com.xnjr.mall.enums.ECurrency;
import com.xnjr.mall.http.BizConnecter;
import com.xnjr.mall.http.JsonUtils;

@Component
public class AccountBOImpl implements IAccountBO {
    static Logger logger = Logger.getLogger(AccountBOImpl.class);

    @Override
    public String doChargeOfflineJf(String fromUserId, String toUserId,
            String amount, String price, String type, String pdf, String refNo,
            String applyUser) {
        XN802120Req req = new XN802120Req();
        req.setFromUserId(fromUserId);
        req.setToUserId(toUserId);
        req.setAmount(amount);
        req.setPrice(price);
        req.setType(type);
        req.setPdf(pdf);
        req.setRefNo(refNo);
        req.setApplyUser(applyUser);
        XN802112Res res = BizConnecter.getBizData("802120",
            JsonUtils.object2Json(req), XN802112Res.class);
        return res.getCqNo();
    }

    @Override
    public String doChargeOfflineWithoutApp(String accountNumber, Long amount,
            String fromType, String fromCode, String pdf, String approveUser,
            String approveNote, String refNo) {
        XN802112Req req = new XN802112Req();
        req.setAccountNumber(accountNumber);
        req.setAmount(String.valueOf(amount));
        req.setFromType(fromType);
        req.setFromCode(fromCode);
        req.setPdf(pdf);
        req.setApproveUser(approveUser);
        req.setApproveNote(approveNote);
        req.setRefNo(refNo);
        XN802112Res res = BizConnecter.getBizData("802112",
            JsonUtils.object2Json(req), XN802112Res.class);
        return res.getCqNo();
    }

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#doChargeOfflineJfWithoutApp(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String doChargeOfflineJfWithoutApp(String fromUserId,
            String toUserId, String amount, String price, String type,
            String pdf, String approveUser, String approveNote, String refNo) {
        XN802122Req req = new XN802122Req();
        req.setFromUserId(fromUserId);
        req.setToUserId(toUserId);
        req.setAmount(amount);
        req.setPrice(price);
        req.setType(type);
        req.setPdf(pdf);
        req.setApproveUser(approveUser);
        req.setApproveNote(approveNote);
        req.setRefNo(refNo);
        XN802122Res res = BizConnecter.getBizData("802122",
            JsonUtils.object2Json(req), XN802122Res.class);
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
    public XN802012Res getAccountByUserId(String userId) {
        return BizConnecter.getBizData("802012",
            JsonUtils.string2Json("userId", userId), XN802012Res.class);
    }

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#getXNBAccountByUserId(java.lang.String)
     */
    @Override
    public XN802013Res getXNBAccountByUserId(String userId) {
        XN802013Req req = new XN802013Req();
        req.setUserId(userId);
        req.setCurrency(ECurrency.XNB.getCode());
        return BizConnecter.getBizData("802013", JsonUtils.object2Json(req),
            XN802013Res.class);
    }

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#getCNYAccountByUserId(java.lang.String)
     */
    @Override
    public XN802013Res getCNYAccountByUserId(String userId) {
        XN802013Req req = new XN802013Req();
        req.setUserId(userId);
        req.setCurrency(ECurrency.CNY.getCode());
        return BizConnecter.getBizData("802013", JsonUtils.object2Json(req),
            XN802013Res.class);
    }

    /** 
     * @see com.xnjr.mall.bo.IAccountBO#doTransferUsers(java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, java.lang.String)
     */
    @Override
    public void doTransferUsers(String fromUserId, String toUserId,
            String direction, Long amount, Long cnyAmount, Long fee,
            String remark) {
        XN802313Req req = new XN802313Req();
        req.setFromUserId(fromUserId);
        req.setToUserId(toUserId);
        req.setDirection(direction);
        req.setAmount(String.valueOf(amount));
        req.setCnyAmount(String.valueOf(cnyAmount));
        req.setFee(String.valueOf(fee));
        req.setRemark(remark);
        BizConnecter.getBizData("802313", JsonUtils.object2Json(req),
            Object.class);
    }
}

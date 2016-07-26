package com.xnjr.mall.dto.req;

import java.util.List;

/**
 * 提交订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN602021Req {
    // 收件编号（必填）
    private String addressCode;

    // 申请人（必填）
    private String applyUser;

    // 申请备注（选填）
    private String applyNote;

    // 发票类型（必填）
    private String receiptType;

    // 发票抬头（必填）
    private String receiptTitle;

    // 对应货品商（必填）
    private String toUser;

    // 购物车列表（必填）
    private List<String> cartCodeList;

    public String getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(String addressCode) {
        this.addressCode = addressCode;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getReceiptType() {
        return receiptType;
    }

    public void setReceiptType(String receiptType) {
        this.receiptType = receiptType;
    }

    public String getReceiptTitle() {
        return receiptTitle;
    }

    public void setReceiptTitle(String receiptTitle) {
        this.receiptTitle = receiptTitle;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public List<String> getCartCodeList() {
        return cartCodeList;
    }

    public void setCartCodeList(List<String> cartCodeList) {
        this.cartCodeList = cartCodeList;
    }

}

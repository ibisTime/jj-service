package com.xnjr.mall.dto.req;

public class XNfd2012Req {
    // 编号（必填）
    private String id;

    // 用户编号（必填）
    private String userId;

    // 银行代码（必填）
    private String bankCode;

    // 支行（必填）
    private String subbranch;

    // 卡号（必填）
    private String bankCardNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }
}

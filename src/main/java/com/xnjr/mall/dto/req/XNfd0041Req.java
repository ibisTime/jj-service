package com.xnjr.mall.dto.req;

public class XNfd0041Req extends APageReq {

    // 账号（必填）
    private String accountNumber;

    // 业务类型（选填）
    private String bizType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

}

package com.xnjr.mall.dto.req;

public class XN802013Req {
    // userId（必填）
    private String userId;

    // 币种（必填）CNY 人民币 XNB 积分虚拟币
    private String currency;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}

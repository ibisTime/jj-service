package com.xnjr.mall.dto.res;

public class XNgs5000Res {

    // 状态(0正常,1程序锁定,2人工锁定)
    private String status;

    // 账户余额(精确到厘,且永远大于等于0）
    private Long amount;

    // 冻结金额（精确到厘,且永远大于等于0）
    private Long frozenAmount;

    // 币种（默认CNY）
    private String currency;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(Long frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}

package com.xnjr.mall.dto.req;

public class XNfd0052Req {

    // 金额(必填)
    private String amount;

    // 取现人编号(必填)
    private String towho;

    // 账户编号(必填)
    private String accountNumber;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTowho() {
        return towho;
    }

    public void setTowho(String towho) {
        this.towho = towho;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}

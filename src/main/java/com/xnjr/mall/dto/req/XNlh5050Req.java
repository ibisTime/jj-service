package com.xnjr.mall.dto.req;

public class XNlh5050Req {
    // 账号
    private String accountNumber;

    // 金额（精确到厘：正数是蓝补;负数是红冲）Long
    private String amount;

    // 申请人
    private String updater;

    // 申请说明
    private String remark;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

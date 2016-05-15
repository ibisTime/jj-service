package com.xnjr.mall.dto.req;

public class XNfd0051Req extends APageReq {

    // 取现订单号（选填）
    private String qxNo;

    // 状态（选填）

    private String status;

    // 支付人（选填）
    private String payUser;

    // 对账人（选填）
    private String checkUser;

    // 对账日期（选填）
    private String workDate;

    // 账号（选填）
    private String accountNumber;

    public String getQxNo() {
        return qxNo;
    }

    public void setQxNo(String qxNo) {
        this.qxNo = qxNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}

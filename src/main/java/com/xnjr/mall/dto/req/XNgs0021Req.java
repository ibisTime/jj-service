package com.xnjr.mall.dto.req;

public class XNgs0021Req extends APageReq {

    private static final long serialVersionUID = 8305074432552201009L;

    // 账号(必填)
    private String accountNumber;

    // 状态(选填)
    private String status;

    // 业务类型(选填)
    private String bizType;

    // 参考订单号(选填)
    private String refNo;

    // 理应对账时间(选填)
    private String workDate;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

}

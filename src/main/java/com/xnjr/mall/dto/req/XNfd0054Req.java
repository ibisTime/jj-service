package com.xnjr.mall.dto.req;

public class XNfd0054Req {

    // 取现订单编号
    private String qxNo;

    // 支付人
    private String payUser;

    // 支付结果
    private String payResult;

    // 支付说明
    private String payNote;

    // 支付单号(支付成功时才有)
    private String payNo;

    // 支付手续费(支付成功时才有)
    private String payFee;

    // 理应对账时间（YYYYMMDD）
    private String workDate;

    public String getQxNo() {
        return qxNo;
    }

    public void setQxNo(String qxNo) {
        this.qxNo = qxNo;
    }

    public String getPayUser() {
        return payUser;
    }

    public void setPayUser(String payUser) {
        this.payUser = payUser;
    }

    public String getPayResult() {
        return payResult;
    }

    public void setPayResult(String payResult) {
        this.payResult = payResult;
    }

    public String getPayNote() {
        return payNote;
    }

    public void setPayNote(String payNote) {
        this.payNote = payNote;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPayFee() {
        return payFee;
    }

    public void setPayFee(String payFee) {
        this.payFee = payFee;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

}

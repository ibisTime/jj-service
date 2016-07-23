package com.xnjr.mall.dto.req;

public class XN802120Req {
    // 来方用户编号(必填)
    private String fromUserId;

    // 去方用户编号(必填)
    private String toUserId;

    // 充值金额（精确到厘）(必填)
    private String amount;

    // 人民币价格（精确到厘）(必填)
    private String price;

    // 类型(下家 1，终端用户 2)(必填)
    private String type;

    // pdf(必填)
    private String pdf;

    // refNo(选填)
    private String refNo;

    // 申请人(选填)
    private String applyUser;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

}

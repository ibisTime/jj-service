package com.xnjr.mall.dto.req;

/**
 * 线下积分申请审核一键通过
 * @author: xieyj 
 * @since: 2016年7月23日 上午6:58:51 
 * @history:
 */
public class XN802122Req {
    // 来方用户编号(必填)
    private String fromUserId;

    // 去方用户编号账号(必填)
    private String toUserId;

    // 充值金额（精确到厘）(必填)
    private String amount;

    // 人民币价格（精确到厘）(必填)
    private String price;

    // 类型(下家 1，终端用户 2)(必填)
    private String type;

    // pdf(必填)
    private String pdf;

    // 审核人(必填)
    private String approveUser;

    // 审核意见(必填)
    private String approveNote;

    // refNo(必填)
    private String refNo;

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

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

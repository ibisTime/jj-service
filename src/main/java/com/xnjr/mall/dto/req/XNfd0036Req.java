package com.xnjr.mall.dto.req;

public class XNfd0036Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 2871368891984686107L;

    // 流水号
    private String afjNo;

    // 业务类型（1取现申请2借款申请）
    private String bizType;

    // 关联单号
    private String refNo;

    // 账号
    private String accountNumber;

    public String getAfjNo() {
        return afjNo;
    }

    public void setAfjNo(String afjNo) {
        this.afjNo = afjNo;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}

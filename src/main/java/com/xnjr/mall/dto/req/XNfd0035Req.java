package com.xnjr.mall.dto.req;

public class XNfd0035Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -5874671080115585192L;

    // 流水号
    private String ajNo;

    // 是否已经对账（0未对账;2表示对账（已对账）；3表示错账（已对账）;9不需要对账）
    private String status;

    // 业务类型（0虚拟币兑换;1充值-1取现;2转入-2转出;9蓝补-9红冲）
    private String bizType;

    // 关联单号
    private String refNo;

    // 理应对账时间(YYYY-MM-DD)
    private String workDate;

    // 对账人（li为程序）
    private String checkUser;

    // 账号
    private String accountNumber;

    public String getAjNo() {
        return ajNo;
    }

    public void setAjNo(String ajNo) {
        this.ajNo = ajNo;
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

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

}

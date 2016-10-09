package com.cdkj.service.dto.req;

public class CD612113Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 申请人编号 (选填)
    private String fromUser;

    // 公司编号 (选填)
    private String companyCode;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }
}

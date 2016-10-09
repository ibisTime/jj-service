package com.cdkj.service.dto.req;

public class CD612110Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 服务名称 (选填)
    private String fromUser;

    // 状态 (选填)
    private String toCode;

    // 公司编号 (选填)
    private String companyCode;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}

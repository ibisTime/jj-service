package com.cdkj.service.dto.req;

public class CD612111Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 发布人编号 (选填)
    private String publisher;

    // 公司编号 (选填)
    private String companyCode;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }
}

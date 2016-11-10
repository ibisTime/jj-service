package com.cdkj.service.dto.req;

public class CD612112Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 发布人编号 (选填)
    private String publisher;

    // 公司编号 (选填)
    private String companyCode;

    // 类型 (选填)
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

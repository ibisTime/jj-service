package com.cdkj.service.dto.req;

public class CD612090Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 职位名称(选填)
    private String name;

    // 是否热门(选填)
    private String isHot;

    // 公司编号(选填)
    private String companyCode;

    // 公司名称(选填)
    private String companyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }
}

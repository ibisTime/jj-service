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

    // 公司-省(选填)
    private String gsProvince;

    // 公司-市(选填)
    private String gsCity;

    // 公司-区(选填)
    private String gsArea;

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

    public String getGsProvince() {
        return gsProvince;
    }

    public void setGsProvince(String gsProvince) {
        this.gsProvince = gsProvince;
    }

    public String getGsCity() {
        return gsCity;
    }

    public void setGsCity(String gsCity) {
        this.gsCity = gsCity;
    }

    public String getGsArea() {
        return gsArea;
    }

    public void setGsArea(String gsArea) {
        this.gsArea = gsArea;
    }
}

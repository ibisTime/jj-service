package com.cdkj.service.dto.req;

public class CD612030Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 服务名称 (选填)
    private String name;

    // 状态 (选填)
    private String status;

    // 公司编号 (选填)
    private String companyCode;

    // 公司名称 (选填)
    private String companyName;

    // 资质编号(选填)
    private String qualityCode;

    // 是否热门(选填)
    private String isHot;

    // 发布人 (选填)
    private String publisher;

    // 处理人 (选填)
    private String dealer;

    // 省 (选填)
    private String province;

    // 市 (选填)
    private String city;

    // 区(选填)
    private String area;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}

package com.cdkj.service.dto.req;

public class CD612030Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 服务名称 (必填)
    private String name;

    // 状态 (必填)
    private String status;

    // 公司编号 (必填)
    private String companyCode;

    // 公司名称 (必填)
    private String companyName;

    // 资质编号(必填)
    private String qualityCode;

    // 是否热门(必填)
    private String isHot;

    // 发布人 (必填)
    private String pubisher;

    // 处理人 (必填)
    private String dealer;

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

    public String getPubisher() {
        return pubisher;
    }

    public void setPubisher(String pubisher) {
        this.pubisher = pubisher;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
}

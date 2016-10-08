package com.cdkj.service.dto.req;

public class CD612000Req {

    // 服务名称 (必填)
    private String name;

    // 公司编号(必填)
    private String companyCode;

    // 最小报价(必填)
    private String quoteMin;

    // 最大报价(必填)
    private String quoteMax;

    // 资质编号(必填)
    private String qualityCode;

    // 棚影数量(必填)
    private String pyNum;

    // 摄影师数量(必填)
    private String sysNum;

    // 是否接受定制需求(必填)
    private String isDz;

    // 擅长拍摄类目(必填)
    private String scpslm;

    // 代表作品(必填)
    private String works;

    // 详细描述(选填)
    private String description;

    // 发布人(必填)
    private String publisher;

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

    public String getQualityCode() {
        return qualityCode;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getIsDz() {
        return isDz;
    }

    public void setIsDz(String isDz) {
        this.isDz = isDz;
    }

    public String getScpslm() {
        return scpslm;
    }

    public void setScpslm(String scpslm) {
        this.scpslm = scpslm;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQuoteMin() {
        return quoteMin;
    }

    public void setQuoteMin(String quoteMin) {
        this.quoteMin = quoteMin;
    }

    public String getQuoteMax() {
        return quoteMax;
    }

    public void setQuoteMax(String quoteMax) {
        this.quoteMax = quoteMax;
    }

    public String getPyNum() {
        return pyNum;
    }

    public void setPyNum(String pyNum) {
        this.pyNum = pyNum;
    }

    public String getSysNum() {
        return sysNum;
    }

    public void setSysNum(String sysNum) {
        this.sysNum = sysNum;
    }
}

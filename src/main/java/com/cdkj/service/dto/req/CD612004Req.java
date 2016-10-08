package com.cdkj.service.dto.req;

public class CD612004Req {

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

    // 提供服务(必填)
    private String tgfw;

    // 收费模式(必填)
    private String feeMode;

    // 付款周期(必填)
    private String payCycle;

    // 擅长运营类目(必填)
    private String scyylm;

    // 成功案例(必填)
    private String sucCase;

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

    public String getTgfw() {
        return tgfw;
    }

    public void setTgfw(String tgfw) {
        this.tgfw = tgfw;
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }

    public String getPayCycle() {
        return payCycle;
    }

    public void setPayCycle(String payCycle) {
        this.payCycle = payCycle;
    }

    public String getScyylm() {
        return scyylm;
    }

    public void setScyylm(String scyylm) {
        this.scyylm = scyylm;
    }

    public String getSucCase() {
        return sucCase;
    }

    public void setSucCase(String sucCase) {
        this.sucCase = sucCase;
    }
}

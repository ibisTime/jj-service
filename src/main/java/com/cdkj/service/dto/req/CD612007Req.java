package com.cdkj.service.dto.req;

public class CD612007Req {

    // 服务编号 (必填)
    private String code;

    // 服务名称 (必填)
    private String name;

    // 最小报价(必填)
    private String quoteMin;

    // 最大报价(必填)
    private String quoteMax;

    // 设计师人数(必填)
    private String designNum;

    // 擅长类目(必填)
    private String sclm;

    // 首页天数(必填)
    private String homeDays;

    // 首页价格(必填)
    private String homePrice;

    // 详情页天数(必填)
    private String detailDays;

    // 详情页价格(必填)
    private String detailPrice;

    // 海报图天数(必填)
    private String bannerDays;

    // 海报图价格(必填)
    private String bannerPrice;

    // 全店设计天数(必填)
    private String allDays;

    // 全店设计价格(必填)
    private String allPrice;

    // 作品(必填)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesignNum() {
        return designNum;
    }

    public void setDesignNum(String designNum) {
        this.designNum = designNum;
    }

    public String getSclm() {
        return sclm;
    }

    public void setSclm(String sclm) {
        this.sclm = sclm;
    }

    public String getHomeDays() {
        return homeDays;
    }

    public void setHomeDays(String homeDays) {
        this.homeDays = homeDays;
    }

    public String getHomePrice() {
        return homePrice;
    }

    public void setHomePrice(String homePrice) {
        this.homePrice = homePrice;
    }

    public String getDetailDays() {
        return detailDays;
    }

    public void setDetailDays(String detailDays) {
        this.detailDays = detailDays;
    }

    public String getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(String detailPrice) {
        this.detailPrice = detailPrice;
    }

    public String getBannerDays() {
        return bannerDays;
    }

    public void setBannerDays(String bannerDays) {
        this.bannerDays = bannerDays;
    }

    public String getBannerPrice() {
        return bannerPrice;
    }

    public void setBannerPrice(String bannerPrice) {
        this.bannerPrice = bannerPrice;
    }

    public String getAllDays() {
        return allDays;
    }

    public void setAllDays(String allDays) {
        this.allDays = allDays;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }
}

package com.cdkj.service.dto.req;

/**
 * 新增客服外包 
 * @author: asus 
 * @since: 2017年6月6日 下午1:52:55 
 * @history:
 */
public class XN612122Req {

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

    // 客服人数(必填)
    private String kfNum;

    // 月均交易额(必填)
    private String mtradeAmount;

    // 客服业务(必填)
    private String business;

    // 收费模式(必填)
    private String feeMode;

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

    public String getKfNum() {
        return kfNum;
    }

    public void setKfNum(String kfNum) {
        this.kfNum = kfNum;
    }

    public String getMtradeAmount() {
        return mtradeAmount;
    }

    public void setMtradeAmount(String mtradeAmount) {
        this.mtradeAmount = mtradeAmount;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }
}

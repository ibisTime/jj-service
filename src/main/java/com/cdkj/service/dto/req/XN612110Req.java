package com.cdkj.service.dto.req;

/**
 * 新增店铺代运营
 * @author: asus 
 * @since: 2017年6月6日 下午1:46:35 
 * @history:
 */
public class XN612110Req {

    // 服务名称 (必填)
    private String name;

    // 缩略图
    private String pic;

    // 广告图
    private String advPic;

    // 公司编号(必填)
    private String companyCode;

    // 最小报价(必填)
    private String quoteMin;

    // 最大报价(必填)
    private String quoteMax;

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }
}

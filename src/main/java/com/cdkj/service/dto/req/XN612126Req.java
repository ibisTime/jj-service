package com.cdkj.service.dto.req;

/**
 * 新增软件外包
 * @author: asus 
 * @since: 2017年6月6日 下午1:55:26 
 * @history:
 */
public class XN612126Req {

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

    // 资质编号(必填)
    private String qualityCode;

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

package com.cdkj.service.dto.req;

/**
 * 新增仓配服务
 * @author: asus 
 * @since: 2017年6月6日 下午1:54:15 
 * @history:
 */
public class XN612124Req {

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

    // 仓库数量(必填)
    private String ckNum;

    // 仓库面积(必填)
    private String ckArea;

    // 货品种类(必填)
    private String goodsKind;

    // 日均发货数量(必填)
    private String dsendNum;

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

    public String getCkNum() {
        return ckNum;
    }

    public void setCkNum(String ckNum) {
        this.ckNum = ckNum;
    }

    public String getCkArea() {
        return ckArea;
    }

    public void setCkArea(String ckArea) {
        this.ckArea = ckArea;
    }

    public String getGoodsKind() {
        return goodsKind;
    }

    public void setGoodsKind(String goodsKind) {
        this.goodsKind = goodsKind;
    }

    public String getDsendNum() {
        return dsendNum;
    }

    public void setDsendNum(String dsendNum) {
        this.dsendNum = dsendNum;
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

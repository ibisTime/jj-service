package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 运营
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class Operate extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 服务名称
    private String name;

    // 缩略图
    private String pic;

    // 广告图
    private String advPic;

    // 公司编号
    private String companyCode;

    // 提供服务
    private String tgfw;

    // 收费模式
    private String feeMode;

    // 付款周期
    private String payCycle;

    // 擅长运营类目
    private String scyylm;

    // 成功案例展示
    private String sucCase;

    // 价最小值
    private Long quoteMin;

    // 报价最大值
    private Long quoteMax;

    // 公司资质编号
    private String qualityCode;

    // 资质编号
    private String qualifyCode;

    // 详细描述
    private String description;

    // UI位置
    private String location;

    // UI顺序
    private String orderNo;

    // 状态
    private String status;

    // 发布人
    private String publisher;

    // 发布时间
    private Date publishDatetime;

    // 处理人
    private String dealer;

    // 处理时间
    private Date dealDatetime;

    // 处理意见
    private String dealNote;

    // *******************************
    // 服务类型
    private String type;

    // 公司-省
    private String province;

    // 公司-市
    private String city;

    // 公司-区
    private String area;

    private Date publishDatetimeStart;

    private Date publishDatetimeEnd;

    private String qualityName;

    // 公司名称
    private String companyName;

    private Company company;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {
        return pic;
    }

    public void setAdvPic(String advPic) {
        this.advPic = advPic;
    }

    public String getAdvPic() {
        return advPic;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setTgfw(String tgfw) {
        this.tgfw = tgfw;
    }

    public String getTgfw() {
        return tgfw;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setPayCycle(String payCycle) {
        this.payCycle = payCycle;
    }

    public String getPayCycle() {
        return payCycle;
    }

    public void setScyylm(String scyylm) {
        this.scyylm = scyylm;
    }

    public String getScyylm() {
        return scyylm;
    }

    public void setSucCase(String sucCase) {
        this.sucCase = sucCase;
    }

    public String getSucCase() {
        return sucCase;
    }

    public void setQuoteMin(Long quoteMin) {
        this.quoteMin = quoteMin;
    }

    public Long getQuoteMin() {
        return quoteMin;
    }

    public void setQuoteMax(Long quoteMax) {
        this.quoteMax = quoteMax;
    }

    public Long getQuoteMax() {
        return quoteMax;
    }

    public void setQualityCode(String qualityCode) {
        this.qualityCode = qualityCode;
    }

    public String getQualityCode() {
        return qualityCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealDatetime(Date dealDatetime) {
        this.dealDatetime = dealDatetime;
    }

    public Date getDealDatetime() {
        return dealDatetime;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
    }

    public String getDealNote() {
        return dealNote;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Date getPublishDatetimeStart() {
        return publishDatetimeStart;
    }

    public void setPublishDatetimeStart(Date publishDatetimeStart) {
        this.publishDatetimeStart = publishDatetimeStart;
    }

    public Date getPublishDatetimeEnd() {
        return publishDatetimeEnd;
    }

    public void setPublishDatetimeEnd(Date publishDatetimeEnd) {
        this.publishDatetimeEnd = publishDatetimeEnd;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQualifyCode() {
        return qualifyCode;
    }

    public void setQualifyCode(String qualifyCode) {
        this.qualifyCode = qualifyCode;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}

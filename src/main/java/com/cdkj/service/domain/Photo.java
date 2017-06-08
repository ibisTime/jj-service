package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 摄影
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class Photo extends ABaseDO {

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

    // 棚影数量
    private Integer pyNum;

    // 摄影师数量
    private Integer sysNum;

    // 是否定制需求
    private String isDz;

    // 擅长拍摄类目
    private String scpslm;

    // 上传代表作品
    private String works;

    // 报价最小值
    private Long quoteMin;

    // 报价最大值
    private Long quoteMax;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getPyNum() {
        return pyNum;
    }

    public void setPyNum(Integer pyNum) {
        this.pyNum = pyNum;
    }

    public Integer getSysNum() {
        return sysNum;
    }

    public void setSysNum(Integer sysNum) {
        this.sysNum = sysNum;
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

    public Long getQuoteMin() {
        return quoteMin;
    }

    public void setQuoteMin(Long quoteMin) {
        this.quoteMin = quoteMin;
    }

    public Long getQuoteMax() {
        return quoteMax;
    }

    public void setQuoteMax(Long quoteMax) {
        this.quoteMax = quoteMax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(Date publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public Date getDealDatetime() {
        return dealDatetime;
    }

    public void setDealDatetime(Date dealDatetime) {
        this.dealDatetime = dealDatetime;
    }

    public String getDealNote() {
        return dealNote;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getQualityName() {
        return qualityName;
    }

    public void setQualityName(String qualityName) {
        this.qualityName = qualityName;
    }

    public String getQualifyCode() {
        return qualifyCode;
    }

    public void setQualifyCode(String qualifyCode) {
        this.qualifyCode = qualifyCode;
    }

}

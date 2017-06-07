package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
* 培训
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class Train extends ABaseDO {

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

    // 讲师总人数
    private Integer lectorNum;

    // 月均培训场次
    private Integer mtrainTimes;

    // 月均培训人数
    private Integer mtrainNum;

    // 第一位讲师简历
    private String resume1;

    // 第二位讲师简历
    private String resume2;

    // 第三位讲师简历
    private String resume3;

    // 培训课程
    private String course;

    // 报价最小值
    private Long quoteMin;

    // 报价最大值
    private Long quoteMax;

    // 资质编号
    private String qualityCode;

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

    public Integer getLectorNum() {
        return lectorNum;
    }

    public void setLectorNum(Integer lectorNum) {
        this.lectorNum = lectorNum;
    }

    public Integer getMtrainTimes() {
        return mtrainTimes;
    }

    public void setMtrainTimes(Integer mtrainTimes) {
        this.mtrainTimes = mtrainTimes;
    }

    public Integer getMtrainNum() {
        return mtrainNum;
    }

    public void setMtrainNum(Integer mtrainNum) {
        this.mtrainNum = mtrainNum;
    }

    public String getResume1() {
        return resume1;
    }

    public void setResume1(String resume1) {
        this.resume1 = resume1;
    }

    public String getResume2() {
        return resume2;
    }

    public void setResume2(String resume2) {
        this.resume2 = resume2;
    }

    public String getResume3() {
        return resume3;
    }

    public void setResume3(String resume3) {
        this.resume3 = resume3;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
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

}

package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;
import com.cdkj.service.dto.res.XN806010Res;

/**
 * 职位
 * @author: asus 
 * @since: 2017年6月5日 下午6:52:59 
 * @history:
 */
public class Position extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 名称
    private String name;

    // 种类
    private String kind;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String area;

    // 工作经验
    private String experience;

    // 学历
    private String education;

    // 类型(1 全职 2兼职 3实习)
    private String type;

    // 招聘人数
    private Integer jobNum;

    // 月薪
    private String msalary;

    // 职位描述
    private String description;

    // 公司编号
    private String companyCode;

    // UI位置
    private String location;

    // UI顺序
    private Integer orderNo;

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

    // 处理备注
    private String dealNote;

    // ****************db properties ******************

    private String companyName;

    // 公司-省
    private String gsProvince;

    // 公司-市
    private String gsCity;

    // 公司-区
    private String gsArea;

    private XN806010Res company;

    // 公司联系人
    private String realName;

    // 联系电话
    private String mobile;

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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getJobNum() {
        return jobNum;
    }

    public void setJobNum(Integer jobNum) {
        this.jobNum = jobNum;
    }

    public String getMsalary() {
        return msalary;
    }

    public void setMsalary(String msalary) {
        this.msalary = msalary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getGsProvince() {
        return gsProvince;
    }

    public void setGsProvince(String gsProvince) {
        this.gsProvince = gsProvince;
    }

    public String getGsCity() {
        return gsCity;
    }

    public void setGsCity(String gsCity) {
        this.gsCity = gsCity;
    }

    public String getGsArea() {
        return gsArea;
    }

    public void setGsArea(String gsArea) {
        this.gsArea = gsArea;
    }

    public XN806010Res getCompany() {
        return company;
    }

    public void setCompany(XN806010Res company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

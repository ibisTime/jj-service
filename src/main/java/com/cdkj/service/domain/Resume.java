package com.cdkj.service.domain;

import java.util.Date;
import java.util.List;

import com.cdkj.service.dao.base.ABaseDO;

/**
 * 简历
 * @author: asus 
 * @since: 2017年6月5日 下午2:28:55 
 * @history:
 */
public class Resume extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 简历名称
    private String name;

    // 是否有工作经验
    private String isWork;

    // 最近公司名称
    private String preCompName;

    // 最近职位名称
    private String prePosName;

    // 最近工作时间
    private String preWorkTime;

    // 最近月薪
    private String preMsalary;

    // 最近职位描述
    private String preDescription;

    // 学历
    private String education;

    // 是否统招
    private String isTz;

    // 就读时间
    private String studyTime;

    // 学校名称
    private String school;

    // 专业名称
    private String profession;

    // 工作类型
    private String type;

    // 期望岗位
    private String expPosition;

    // 期望月薪
    private String expMsalary;

    // 期望工作地点(省)
    private String expProvince;

    // 期望工作地点(市)
    private String expCity;

    // 工作状态
    private String workStatus;

    // 是否公开
    private String isOpen;

    // 使用次数
    private Integer useTimes;

    // UI位置
    private String location;

    // UI顺序
    private Integer orderNo;

    // 状态
    private String status;

    // 发布人
    private String publisher;

    // 更新时间
    private Date publishDatetime;

    // 处理人
    private String dealer;

    // 处理时间
    private Date dealDatetime;

    // 违规说明
    private String dealNote;

    // ****************db properties ******************
    private String mobile;

    private String workTime;

    List<String> expPositionList;

    private String realName;

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

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getPreCompName() {
        return preCompName;
    }

    public void setPreCompName(String preCompName) {
        this.preCompName = preCompName;
    }

    public String getPrePosName() {
        return prePosName;
    }

    public void setPrePosName(String prePosName) {
        this.prePosName = prePosName;
    }

    public String getPreWorkTime() {
        return preWorkTime;
    }

    public void setPreWorkTime(String preWorkTime) {
        this.preWorkTime = preWorkTime;
    }

    public String getPreMsalary() {
        return preMsalary;
    }

    public void setPreMsalary(String preMsalary) {
        this.preMsalary = preMsalary;
    }

    public String getPreDescription() {
        return preDescription;
    }

    public void setPreDescription(String preDescription) {
        this.preDescription = preDescription;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIsTz() {
        return isTz;
    }

    public void setIsTz(String isTz) {
        this.isTz = isTz;
    }

    public String getStudyTime() {
        return studyTime;
    }

    public void setStudyTime(String studyTime) {
        this.studyTime = studyTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpPosition() {
        return expPosition;
    }

    public void setExpPosition(String expPosition) {
        this.expPosition = expPosition;
    }

    public String getExpMsalary() {
        return expMsalary;
    }

    public void setExpMsalary(String expMsalary) {
        this.expMsalary = expMsalary;
    }

    public String getExpProvince() {
        return expProvince;
    }

    public void setExpProvince(String expProvince) {
        this.expProvince = expProvince;
    }

    public String getExpCity() {
        return expCity;
    }

    public void setExpCity(String expCity) {
        this.expCity = expCity;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    public Integer getUseTimes() {
        return useTimes;
    }

    public void setUseTimes(Integer useTimes) {
        this.useTimes = useTimes;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public List<String> getExpPositionList() {
        return expPositionList;
    }

    public void setExpPositionList(List<String> expPositionList) {
        this.expPositionList = expPositionList;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

}

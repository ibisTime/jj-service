package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
 * 意向
 * @author: xieyj 
 * @since: 2016年10月7日 下午7:07:24 
 * @history:
 */
public class Intention extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型(1 职位申请 2 对服务感兴趣 3 对需求感兴趣 4 对简历感兴趣)
    private String type;

    // 状态
    private String status;

    // 对某事务感兴趣
    private String toCode;

    // 来源方
    private String fromUser;

    // 来源方投递东西
    private String fromRole;

    // 发生时间
    private Date fromDatetime;

    // 处理人
    private String dealer;

    // 处理时间
    private Date dealDatetime;

    // 处理意见
    private String dealNote;

    // ****************db properties ******************

    // 服务名称
    private String serveName;

    // 需求名称
    private String demandName;

    // 需求名称
    private String resumeName;

    // 职位名称
    private String positionName;

    // 发布人编号
    private String publisher;

    // 发布公司编号
    private String fromCompany;

    // 公司编号
    private String companyCode;

    // 公司联系人
    private String companyUser;

    // 公司联系方式
    private String companyMobile;

    // 用户昵称
    private String userNickname;

    // 用户姓名
    private String userName;

    // 用户联系方式
    private String userMobile;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getFromRole() {
        return fromRole;
    }

    public void setFromRole(String fromRole) {
        this.fromRole = fromRole;
    }

    public Date getFromDatetime() {
        return fromDatetime;
    }

    public void setFromDatetime(Date fromDatetime) {
        this.fromDatetime = fromDatetime;
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getServeName() {
        return serveName;
    }

    public void setServeName(String serveName) {
        this.serveName = serveName;
    }

    public String getDemandName() {
        return demandName;
    }

    public void setDemandName(String demandName) {
        this.demandName = demandName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getFromCompany() {
        return fromCompany;
    }

    public void setFromCompany(String fromCompany) {
        this.fromCompany = fromCompany;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}

package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
* CB_INTENTION
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class CbIntention extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 意向人
    private String intName;

    // 联系方式
    private String intMobile;

    // 公司编号
    private String companyCode;

    // 服务编号
    private String serviceCode;

    // 职位编号
    private String positionCode;

    // 简历编号
    private String resumeCode;

    // 意向描述
    private String hzContent;

    // 提交人
    private String submitter;

    // 提交时间
    private Date submitDatetime;

    // 状态
    private String status;

    // 最后修改人
    private String updater;

    // 最后修改时间
    private Date updateDatetime;

    // 备注
    private String remark;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setIntName(String intName) {
        this.intName = intName;
    }

    public String getIntName() {
        return intName;
    }

    public void setIntMobile(String intMobile) {
        this.intMobile = intMobile;
    }

    public String getIntMobile() {
        return intMobile;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getUpdater() {
        return updater;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getHzContent() {
        return hzContent;
    }

    public void setHzContent(String hzContent) {
        this.hzContent = hzContent;
    }

    public Date getSubmitDatetime() {
        return submitDatetime;
    }

    public void setSubmitDatetime(Date submitDatetime) {
        this.submitDatetime = submitDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}

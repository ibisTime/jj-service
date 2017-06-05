package com.cdkj.service.domain;

import java.util.Date;

import com.cdkj.service.dao.base.ABaseDO;

/**
* BC_INTENTION
* @author: shan
* @since: 2017年06月05日
* @history:
*/
public class BcIntention extends ABaseDO {

    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 类型
    private String type;

    // 公司编号
    private String companyCode;

    // 需求编号
    private String demandCode;

    // 简历编号
    private String resumeCode;

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

    // 归属用户ID
    private String gsUserId;

    // *************BD****************
    // 简历名称
    private String jlName;

    // 需求名称
    private String xqName;

    // 公司名称
    private String gsName;

    // 公司联系方式
    private String gsMobile;

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

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setDemandCode(String demandCode) {
        this.demandCode = demandCode;
    }

    public String getDemandCode() {
        return demandCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setSubmitDatetime(Date submitDatetime) {
        this.submitDatetime = submitDatetime;
    }

    public Date getSubmitDatetime() {
        return submitDatetime;
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

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public String getGsUserId() {
        return gsUserId;
    }

    public void setGsUserId(String gsUserId) {
        this.gsUserId = gsUserId;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public String getJlName() {
        return jlName;
    }

    public void setJlName(String jlName) {
        this.jlName = jlName;
    }

    public String getXqName() {
        return xqName;
    }

    public void setXqName(String xqName) {
        this.xqName = xqName;
    }

    public String getGsName() {
        return gsName;
    }

    public void setGsName(String gsName) {
        this.gsName = gsName;
    }

    public String getGsMobile() {
        return gsMobile;
    }

    public void setGsMobile(String gsMobile) {
        this.gsMobile = gsMobile;
    }

}

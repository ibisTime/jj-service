package com.cdkj.service.dto.req;

/**
 * CB意向申请/职位申请
 * @author: asus 
 * @since: 2017年6月7日 下午5:19:35 
 * @history:
 */
public class XN612170Req {
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

    // 洽谈内容
    private String hzContent;

    // 提交人
    private String submitter;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntName() {
        return intName;
    }

    public void setIntName(String intName) {
        this.intName = intName;
    }

    public String getIntMobile() {
        return intMobile;
    }

    public void setIntMobile(String intMobile) {
        this.intMobile = intMobile;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode;
    }

    public String getHzContent() {
        return hzContent;
    }

    public void setHzContent(String hzContent) {
        this.hzContent = hzContent;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }
}

package com.cdkj.service.dto.req;

/**
 * 分页查询CB意向
 * @author: asus 
 * @since: 2017年6月7日 下午5:25:49 
 * @history:
 */
public class XN612175Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

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

    // 需求编号
    private String resumeCode;

    // 状态
    private String status;

    // 提交人
    private String submitter;

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

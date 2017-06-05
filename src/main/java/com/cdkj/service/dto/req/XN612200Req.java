package com.cdkj.service.dto.req;

/**
 * BC意向申请
 * @author: asus 
 * @since: 2017年6月5日 下午5:18:33 
 * @history:
 */
public class XN612200Req {
    // 类型（1 对需求感兴趣 2 对简历感兴趣 ）
    private String type;

    // 公司编号
    private String companyCode;

    // 需求编号
    private String demandCode;

    // 简历编号
    private String resumeCode;

    // 提交人
    private String submitter;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getDemandCode() {
        return demandCode;
    }

    public void setDemandCode(String demandCode) {
        this.demandCode = demandCode;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }
}

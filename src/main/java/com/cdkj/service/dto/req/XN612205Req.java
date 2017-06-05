package com.cdkj.service.dto.req;

/**
 * 分页查询BC意向
 * @author: asus 
 * @since: 2017年6月5日 下午5:38:00 
 * @history:
 */
public class XN612205Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 公司编号
    private String companyCode;

    // 需求编号
    private String demandCode;

    // 简历编号
    private String resumeCode;

    // 状态
    private String status;

    // 提交人
    private String submiter;

    // 归属
    private String gsUserId;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubmiter() {
        return submiter;
    }

    public void setSubmiter(String submiter) {
        this.submiter = submiter;
    }

    public String getGsUserId() {
        return gsUserId;
    }

    public void setGsUserId(String gsUserId) {
        this.gsUserId = gsUserId;
    }
}

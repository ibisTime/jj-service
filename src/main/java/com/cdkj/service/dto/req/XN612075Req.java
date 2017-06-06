package com.cdkj.service.dto.req;

/**
 * 分页查询公司资质
 * @author: asus 
 * @since: 2017年6月6日 上午11:43:37 
 * @history:
 */
public class XN612075Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 资质编号
    private String qualifyCode;

    // 资质类型
    private String qualifyType;

    // 公司编号
    private String companyCode;

    // 状态
    private String status;

    // 申请人
    private String applyUser;

    // 审核人
    private String approveUser;

    public String getQualifyCode() {
        return qualifyCode;
    }

    public void setQualifyCode(String qualifyCode) {
        this.qualifyCode = qualifyCode;
    }

    public String getQualifyType() {
        return qualifyType;
    }

    public void setQualifyType(String qualifyType) {
        this.qualifyType = qualifyType;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }
}

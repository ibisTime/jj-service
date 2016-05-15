package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 上午6:30:16 
 * @history:
 */
public class XNfd2066Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 用户编号(必填)
    private String userId;

    // 公司编号(必填)
    private String companyCode;

    // 申请公函(必填)
    private String sqghPicture;

    // 备注(选填)
    private String remark;

    // 更新人(必填)
    private String updater;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSqghPicture() {
        return sqghPicture;
    }

    public void setSqghPicture(String sqghPicture) {
        this.sqghPicture = sqghPicture;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}

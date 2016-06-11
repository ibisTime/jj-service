/**
 * @Title XN602402Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午4:33:55 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/**
 * 受款账号-修改
 * @author: xieyj 
 * @since: 2016年6月11日 下午4:33:55 
 * @history:
 */
public class XN602402Req {
    // 编号(必填)
    private String code;

    // 公司编号(必填)
    private String companyCode;

    // 银行+支行全称(必填)
    private String subbranch;

    // 开户账号(必填)
    private String cardNo;

    // 状态(必填)
    private String status;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

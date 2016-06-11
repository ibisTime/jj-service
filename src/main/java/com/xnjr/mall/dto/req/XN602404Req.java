/**
 * @Title XN602404Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年6月11日 下午4:33:55 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/**
 * 受款账号-列表查询
 * @author: xieyj 
 * @since: 2016年6月11日 下午4:33:55 
 * @history:
 */
public class XN602404Req {

    // 公司编号(选填)
    private String companyCode;

    // 银行+支行全称(选填)
    private String subbranch;

    // 开户账号(选填)
    private String cardNo;

    // 状态(选填)
    private String status;

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
}

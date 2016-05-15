/**
 * @Title XNfd2050Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 上午6:27:17 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 上午6:27:17 
 * @history:
 */
public class XNfd2050Req {

    // 公司编号(必填)
    private String companyCode;

    // 银行编号(必填)
    private String bankCode;

    // 支行(必填)
    private String subbranch;

    // 企业账号(必填)
    private String cardNo;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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

}

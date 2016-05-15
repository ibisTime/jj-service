/**
 * @Title XNfd2052Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 上午6:30:16 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 上午6:30:16 
 * @history:
 */
public class XNfd2052Req {
    // 序号(必填)
    private String id;

    // 银行编号(必填)
    private String bankCode;

    // 支行(必填)
    private String subbranch;

    // 企业账号(必填)
    private String cardNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

/**
 * @Title CD612050.java 
 * @Package com.cdkj.service.dto.req 
 * @Description 
 * @author xieyj  
 * @date 2016年10月7日 下午5:37:47 
 * @version V1.0   
 */
package com.cdkj.service.dto.req;

/** 
 * 简历违规处理，状态更改为违规
 * @author: zuixian 
 * @since: 2016年10月8日 下午3:47:18 
 * @history:
 */
public class XN612183Req {

    // 简历编号(必填)
    private String code;

    // 处理意见(必填)
    private String dealNote;

    // 处理人(必填)
    private String dealer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealNote() {
        return dealNote;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }
}

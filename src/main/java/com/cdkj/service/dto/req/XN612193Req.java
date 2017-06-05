package com.cdkj.service.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:22:58 
 * @history:
 */
public class XN612193Req {
    // 编号(必填)
    private String code;

    // 处理人(必填)
    private String dealer;

    // 处理意见
    private String dealNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getDealNote() {
        return dealNote;
    }

    public void setDealNote(String dealNote) {
        this.dealNote = dealNote;
    }
}

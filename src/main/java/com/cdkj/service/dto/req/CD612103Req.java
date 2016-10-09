package com.cdkj.service.dto.req;

public class CD612103Req {

    // 申请编号 (必填)
    private String code;

    // 处理意见
    private String dealNote;

    // 处理人 (必填)
    private String dealer;

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

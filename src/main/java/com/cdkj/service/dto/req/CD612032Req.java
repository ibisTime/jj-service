package com.cdkj.service.dto.req;

public class CD612032Req {

    // 需求方编号(必填)
    private String fromUser;

    // 服务编号 (必填)
    private String toCode;

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUserS) {
        this.fromUser = fromUserS;
    }

    public String getToCode() {
        return toCode;
    }

    public void setToCode(String toCode) {
        this.toCode = toCode;
    }
}

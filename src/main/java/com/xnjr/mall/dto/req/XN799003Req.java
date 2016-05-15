package com.xnjr.mall.dto.req;

public class XN799003Req {
    // 接受短信的手机号--必填
    private String mobile;

    // 业务类型--必填
    private String bizType;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

}

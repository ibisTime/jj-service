package com.xnjr.mall.dto.req;

public class XN799002Req {
    // 接受短信的手机号--必填
    private String mobile;

    // 待验证的手机验证码
    private String captcha;

    // 业务类型--必填
    private String bizType;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

}

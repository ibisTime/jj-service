package com.xnjr.mall.dto.req;

public class XNfd0007Req {

    // 手机号（必填）
    private String mobile;

    // 短信验证码（必填）
    private String smsCaptcha;

    // 新登录密码（必填）
    private String newLoginPwd;

    // 新登录密码强度（必填）
    private String newLoginPwdStrength;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCaptcha() {
        return smsCaptcha;
    }

    public void setSmsCaptcha(String smsCaptcha) {
        this.smsCaptcha = smsCaptcha;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

    public String getNewLoginPwdStrength() {
        return newLoginPwdStrength;
    }

    public void setNewLoginPwdStrength(String newLoginPwdStrength) {
        this.newLoginPwdStrength = newLoginPwdStrength;
    }
}

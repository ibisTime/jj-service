package com.xnjr.mall.dto.req;

public class XNgs0006Req extends APageReq {

    // 手机号
    private String mobile;

    // 真实姓名
    private String realName;

    // 操盘手等级
    private String level;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}

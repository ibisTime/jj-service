package com.xnjr.mall.dto.req;

public class XNgs0004Req {
    // 用户编号
    private String userId;

    // 旧交易密码
    private String oldTradePwd;

    // 旧交易密码
    private String newTradePwd;

    // 新密码 强度
    private String newTradePwdStrength;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldTradePwd() {
        return oldTradePwd;
    }

    public void setOldTradePwd(String oldTradePwd) {
        this.oldTradePwd = oldTradePwd;
    }

    public String getNewTradePwd() {
        return newTradePwd;
    }

    public void setNewTradePwd(String newTradePwd) {
        this.newTradePwd = newTradePwd;
    }

    public String getNewTradePwdStrength() {
        return newTradePwdStrength;
    }

    public void setNewTradePwdStrength(String newTradePwdStrength) {
        this.newTradePwdStrength = newTradePwdStrength;
    }

}

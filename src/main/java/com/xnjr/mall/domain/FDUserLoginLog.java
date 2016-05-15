package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

public class FDUserLoginLog extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private Date loginDatetimeStart;

    private Date loginDatetimeEnd;

    // *************db properties******************
    // 用户编号
    private String userId;

    // 登录时间
    private Date loginDatetime;

    // 登录IP
    private String loginIp;

    // 是否成功
    private String isSuccess;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getLoginDatetime() {
        return loginDatetime;
    }

    public void setLoginDatetime(Date loginDatetime) {
        this.loginDatetime = loginDatetime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getLoginDatetimeStart() {
        return loginDatetimeStart;
    }

    public void setLoginDatetimeStart(Date loginDatetimeStart) {
        this.loginDatetimeStart = loginDatetimeStart;
    }

    public Date getLoginDatetimeEnd() {
        return loginDatetimeEnd;
    }

    public void setLoginDatetimeEnd(Date loginDatetimeEnd) {
        this.loginDatetimeEnd = loginDatetimeEnd;
    }
}

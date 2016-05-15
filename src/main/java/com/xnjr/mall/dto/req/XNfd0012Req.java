package com.xnjr.mall.dto.req;

public class XNfd0012Req {
    // 用户编号(选填)
    private String userId;

    // 手机号(选填)
    private String mobile;

    // 身份标识(选填)
    private String userKind;

    // 推荐人(选填)
    private String userReferee;

    // 证件类型(选填)
    private String idKind;

    // 证件号码(选填)
    private String idNo;

    // 真实姓名(选填)
    private String realName;

    // 状态(选填)
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserKind() {
        return userKind;
    }

    public void setUserKind(String userKind) {
        this.userKind = userKind;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.xnjr.mall.dto.req;

public class XN798001Req {
    // 系统编号(必填)
    private String systemId;

    // 用户编号(必填)
    private String userId;

    // 真实姓名(必填)
    private String realName;

    // 证件类型(必填)
    private String idKind;

    // 证件编号(必填)
    private String idNo;

    // 备注（选填）
    private String remark;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

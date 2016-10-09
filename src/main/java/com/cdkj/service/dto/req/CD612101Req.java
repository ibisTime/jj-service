package com.cdkj.service.dto.req;

public class CD612101Req {

    // 用户编号(必填)
    private String userId;

    // 简历编号 (必填)
    private String resumeCode;

    // 职位编号 (必填)
    private String positionCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResumeCode() {
        return resumeCode;
    }

    public void setResumeCode(String resumeCode) {
        this.resumeCode = resumeCode;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }
}

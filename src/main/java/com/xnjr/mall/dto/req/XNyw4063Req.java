package com.xnjr.mall.dto.req;

public class XNyw4063Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -5855900265053195566L;

    // 业务编号
    private String code;

    // 业务名称
    private String name;

    // '状态'
    private String status;

    // 是否可见：1=前端可见；0=前端不可见
    private String isVisual;

    // 发起人
    private String applyUser;

    // 审核人
    private String checkUser;

    // 项目编号
    private String subjectCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsVisual() {
        return isVisual;
    }

    public void setIsVisual(String isVisual) {
        this.isVisual = isVisual;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

}

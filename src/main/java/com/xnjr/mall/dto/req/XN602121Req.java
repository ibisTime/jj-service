package com.xnjr.mall.dto.req;

public class XN602121Req {

    // 编号(必填)
    private String code;

    // 审核人(必填)
    private String approveUser;

    // 审核结果(必填) 0 不通过 1 通过
    private String approveResult;

    // 审核备注(必填)
    private String approveNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }
}

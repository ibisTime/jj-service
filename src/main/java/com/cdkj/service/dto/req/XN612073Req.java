package com.cdkj.service.dto.req;

/**
 * 审批公司资质
 * @author: asus 
 * @since: 2017年6月6日 上午11:41:43 
 * @history:
 */
public class XN612073Req {
    // 编号
    private String code;

    // 审批人
    private String approveUser;

    // 审批结果
    private String approveResult;

    // 审批备注
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

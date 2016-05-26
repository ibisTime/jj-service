package com.xnjr.mall.dto.req;

/**
 * 取消订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN602028Req {

    // 编号（必填）
    private String code;

    // 反馈人（必填）
    private String approveUser;

    // 反馈备注（选填）
    private String approveNote;

    public String getCode() {
        return code;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.xnjr.mall.dto.req;

/**
 * 取消订单
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:46:53 
 * @history:
 */
public class XN602023Req {

    // 用户编号（必填）
    private String userId;

    // 编号（必填）
    private String code;

    // 取消原因（必填）
    private String applyNote;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }
}

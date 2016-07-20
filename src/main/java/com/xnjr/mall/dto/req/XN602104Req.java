package com.xnjr.mall.dto.req;

/**
 * 扫描积分块，需审批产生积分申请；无需审批直接从商家里扣除积分，直接加上
 * @author: xieyj 
 * @since: 2016年7月20日 下午5:38:20 
 * @history:
 */
public class XN602104Req {

    // 编号(必填)
    private String code;

    // 用户编号(必填)
    private String userId;

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
}

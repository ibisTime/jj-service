package com.cdkj.service.dto.req;

/**
 * 热门位置上下移
 * @author: asus 
 * @since: 2017年6月6日 上午10:09:32 
 * @history:
 */
public class XN612054Req {
    // 编号
    private String code;

    // 动作（1 上移 0 下移）
    private String action;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}

package com.cdkj.service.dto.req;

/**
 * 培训服务上下移动
 * @author: asus 
 * @since: 2017年6月6日 下午2:09:40 
 * @history:
 */
public class XN612095Req {

    // 服务编号(必填)
    private String code;

    // 行为 (必填)
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

package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:41:02 
 * @history:
 */
public class XNfd2042Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 用户编号(必填)
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

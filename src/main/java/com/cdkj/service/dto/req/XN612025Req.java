package com.cdkj.service.dto.req;

/**
 * 分页查询组
 * @author: asus 
 * @since: 2017年6月4日 下午5:08:39 
 * @history:
 */
public class XN612025Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 用户编号
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

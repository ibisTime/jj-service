package com.xnjr.mall.dto.req;

/**
 * 修改用户状态
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:49:39 
 * @history:
 */
public class XNlh0003Req {

    // 用户编号（必填）
    private String userId;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

package com.xnjr.mall.dto.req;

/**
 * 修改交易密码
 * @author: Gejin 
 * @since: 2016年4月16日 下午6:05:52 
 * @history:
 */
public class XNlh0007Req {
    // 用户编号（必填）
    private String userId;

    // 原密码（必填）
    private String oldTradePwd;

    // 新密码（必填）
    private String newTradePwd;

    // 新密码强度（必填）
    private String newTradePwdStrength;

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

    public String getOldTradePwd() {
        return oldTradePwd;
    }

    public void setOldTradePwd(String oldTradePwd) {
        this.oldTradePwd = oldTradePwd;
    }

    public String getNewTradePwd() {
        return newTradePwd;
    }

    public void setNewTradePwd(String newTradePwd) {
        this.newTradePwd = newTradePwd;
    }

    public String getNewTradePwdStrength() {
        return newTradePwdStrength;
    }

    public void setNewTradePwdStrength(String newTradePwdStrength) {
        this.newTradePwdStrength = newTradePwdStrength;
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

package com.xnjr.mall.dto.req;

/**
 * 修改登录密码
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:56:26 
 * @history:
 */
public class XNlh0005Req {

    // 用户编号（必填）
    private String userId;

    // 原密码（必填）
    private String oldLoginPwd;

    // 新密码（必填）
    private String newLoginPwd;

    // 新密码强度（必填）
    private String newLoginPwdStrength;

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

    public String getOldLoginPwd() {
        return oldLoginPwd;
    }

    public void setOldLoginPwd(String oldLoginPwd) {
        this.oldLoginPwd = oldLoginPwd;
    }

    public String getNewLoginPwd() {
        return newLoginPwd;
    }

    public void setNewLoginPwd(String newLoginPwd) {
        this.newLoginPwd = newLoginPwd;
    }

    public String getNewLoginPwdStrength() {
        return newLoginPwdStrength;
    }

    public void setNewLoginPwdStrength(String newLoginPwdStrength) {
        this.newLoginPwdStrength = newLoginPwdStrength;
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

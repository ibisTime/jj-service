package com.xnjr.mall.dto.req;

/**
 * 管理员强制重置登录密码
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:59:15 
 * @history:
 */
public class XNlh0006Req {

    // 管理员账号（必填）
    private String adminId;

    // 管理员交易密码（必填）
    private String adminTradePwd;

    // 用户编号（必填）
    private String userId;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminTradePwd() {
        return adminTradePwd;
    }

    public void setAdminTradePwd(String adminTradePwd) {
        this.adminTradePwd = adminTradePwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

}

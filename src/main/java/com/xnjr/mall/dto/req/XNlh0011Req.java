package com.xnjr.mall.dto.req;

/**
 * 登陆
 * @author: Gejin 
 * @since: 2016年4月16日 下午6:18:32 
 * @history:
 */
public class XNlh0011Req {

    // 用户名（必填）
    private String loginName;

    // 密码（必填）
    private String loginPwd;

    // IP（必填）
    private String loginIp;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

}

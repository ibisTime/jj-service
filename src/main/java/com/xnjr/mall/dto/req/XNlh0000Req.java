package com.xnjr.mall.dto.req;

/**
 * 系统用户-分页查询用户Req
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:34:26 
 * @history:
 */
public class XNlh0000Req extends APageReq {

    private static final long serialVersionUID = 8457280753217715391L;

    // 六方（选填）
    private String kind;

    // 角色编号（选填）
    private String roleCode;

    // 登录名（选填）
    private String loginName;

    // 真实姓名（选填）
    private String realName;

    // 推荐人（选填）
    private String userReferee;

    // 状态（选填）
    private String status;

    // 联系方式（选填）
    private String contact;

    // 更新人（选填）
    private String updater;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserReferee() {
        return userReferee;
    }

    public void setUserReferee(String userReferee) {
        this.userReferee = userReferee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}

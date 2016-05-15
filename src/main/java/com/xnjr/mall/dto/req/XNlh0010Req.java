package com.xnjr.mall.dto.req;

/**
 * 分配用户角色
 * @author: Gejin 
 * @since: 2016年4月16日 下午6:15:39 
 * @history:
 */
public class XNlh0010Req {

    // 用户编号（必填）
    private String userId;

    // 角色编号（必填）
    private String roleCode;

    // 更改人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

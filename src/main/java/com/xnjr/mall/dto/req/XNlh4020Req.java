package com.xnjr.mall.dto.req;

/**
 * 菜单角色-查询菜单列表Req
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:26:50 
 * @history:
 */
public class XNlh4020Req {

    // 角色编号（必填）
    private String roleCode;

    // 菜单父节点编号（选填）
    private String parentCode;

    // 菜单类型（选填）
    private String type;

    // 哪一方(选填)
    private String kind;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }
}

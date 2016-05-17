package com.xnjr.mall.dto.req;

/**
 * 菜单角色-查询菜单列表Req
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:26:50 
 * @history:
 */
public class XNlh4023Req {

    // 角色编号（必填）
    private String roleCode;

    // 菜单顶级节点编号（选填）
    private String topParentCode;

    // 菜单类型（选填）
    private String type;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getTopParentCode() {
        return topParentCode;
    }

    public void setTopParentCode(String topParentCode) {
        this.topParentCode = topParentCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.xnjr.mall.dto.req;

public class XNlh4000Req extends APageReq {

    private static final long serialVersionUID = 5138736221155343722L;

    // 六方(选填)
    private String kind;

    // 菜单名称(选填)
    private String name;

    // 父菜单编号(选填)
    private String parentCode;

    // 类型(选填)
    private String type;

    // 更新人(选填)
    private String updater;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}

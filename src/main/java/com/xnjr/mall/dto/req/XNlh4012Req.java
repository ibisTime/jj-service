package com.xnjr.mall.dto.req;

/**
 * 增加角色
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:17:27 
 * @history:
 */
public class XNlh4012Req {

    // 六方(必填)
    private String kind;

    // 角色名称(必填)
    private String name;

    // 角色等级(必填)
    private String level;

    // 更新人(必填)
    private String updater;

    // 备注(选填)
    private String remark;

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
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

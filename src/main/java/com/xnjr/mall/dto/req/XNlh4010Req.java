package com.xnjr.mall.dto.req;

/**
 * 分页查询角色
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:12:52 
 * @history:
 */
public class XNlh4010Req extends APageReq {

    // 编号(选填)
    private String code;

    // 六方(选填)
    private String kind;

    // 角色名称(选填)
    private String name;

    // 角色等级(选填)
    private String level;

    // 更新人(选填)
    private String updater;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

}

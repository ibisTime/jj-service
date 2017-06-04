package com.cdkj.service.dto.req;

/**
 * 修改资质
 * @author: asus 
 * @since: 2017年6月4日 下午4:14:45 
 * @history:
 */
public class XN612012Req {
    // 编号
    private String code;

    // 类型
    private String type;

    // 名称
    private String name;

    // 描述
    private String description;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

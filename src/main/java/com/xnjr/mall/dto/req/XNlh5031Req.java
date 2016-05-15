package com.xnjr.mall.dto.req;

public class XNlh5031Req {
    // 编号
    private Long id;

    // 值（必填）
    private String cvalue;

    // 配置说明（必填）
    private String note;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCvalue() {
        return cvalue;
    }

    public void setCvalue(String cvalue) {
        this.cvalue = cvalue;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

package com.xnjr.mall.dto.req;

/**
 * 修改用户联系方式
 * @author: Gejin 
 * @since: 2016年4月16日 下午6:12:10 
 * @history:
 */
public class XNlh0009Req {

    // 用户编号（必填）
    private String userId;

    // 联系方式（必填）
    private String contact;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

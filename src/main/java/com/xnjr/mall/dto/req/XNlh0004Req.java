package com.xnjr.mall.dto.req;

/**
 * 补充实名信息
 * @author: Gejin 
 * @since: 2016年4月16日 下午5:53:40 
 * @history:
 */
public class XNlh0004Req {

    // 用户编号（必填）
    private String userId;

    // 证件类型（必填）
    private String idKind;

    // 证件号码（必填）
    private String idNo;

    // 真实姓名（必填）
    private String realName;

    // 更新人（必填）
    private String updater;

    // 备注（选填）
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

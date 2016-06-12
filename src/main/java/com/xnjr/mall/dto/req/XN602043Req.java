package com.xnjr.mall.dto.req;

/**
 * 确认收货Req
 * @author: xieyj 
 * @since: 2016年6月12日 上午9:27:04 
 * @history:
 */
public class XN602043Req {

    // 编号(必填)
    private String code;

    // 更新人(必填)
    private String updater;

    // 备注(必填)
    private String remark;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

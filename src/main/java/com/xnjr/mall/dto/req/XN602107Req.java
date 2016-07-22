package com.xnjr.mall.dto.req;

/**
 * 积分二维码作废
 * @author: xieyj 
 * @since: 2016年7月20日 下午5:38:20 
 * @history:
 */
public class XN602107Req {

    // 编号(必填)
    private String integralCode;

    // 更新人(必填)
    private String updater;

    // 备注(必填)
    private String remark;

    public String getIntegralCode() {
        return integralCode;
    }

    public void setIntegralCode(String integralCode) {
        this.integralCode = integralCode;
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

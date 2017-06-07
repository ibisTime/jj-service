package com.cdkj.service.dto.req;

/**
 * 处理CB意向/申请职位处理，状态更改为已完成(简单查看)
 * @author: asus 
 * @since: 2017年6月7日 下午5:23:18 
 * @history:
 */
public class XN612173Req {
    // 编号
    private String code;

    // 处理结果
    private String dealResult;

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

    public String getDealResult() {
        return dealResult;
    }

    public void setDealResult(String dealResult) {
        this.dealResult = dealResult;
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

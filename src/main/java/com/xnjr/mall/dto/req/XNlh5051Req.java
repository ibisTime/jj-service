package com.xnjr.mall.dto.req;

public class XNlh5051Req {
    // 红蓝订单编号
    private String hlNo;

    // 审批人
    private String updater;

    // 审批意见
    private String approveResult;

    // 审批意见说明
    private String remark;

    public String getHlNo() {
        return hlNo;
    }

    public void setHlNo(String hlNo) {
        this.hlNo = hlNo;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
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

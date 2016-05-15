package com.xnjr.mall.dto.req;

public class XNlh5060Req {
    // 流水号(必填)
    private String ajNo;

    // 类型(必填)：bk=银行方；gs=中国高盛；pt=平台方；fd=资金方；td=贸易方
    private String type;

    // 对账人(必填)
    private String checkUser;

    // 金额（精确到厘：正数是蓝补;负数是红冲；0表示账已平）Long
    private String amount;

    // 申请说明
    private String remark;

    public String getAjNo() {
        return ajNo;
    }

    public void setAjNo(String ajNo) {
        this.ajNo = ajNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCheckUser() {
        return checkUser;
    }

    public void setCheckUser(String checkUser) {
        this.checkUser = checkUser;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

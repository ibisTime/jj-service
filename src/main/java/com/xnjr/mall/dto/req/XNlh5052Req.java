package com.xnjr.mall.dto.req;

public class XNlh5052Req extends APageReq {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 3469529018797225297L;

    // 订单号
    private String hlNo;

    // 类型：1=调账订单（不必对账）；2=人工干预（需要对账）
    private String type;

    // 状态
    private String status;

    // 方向：1=蓝补；0=红冲
    private String direction;

    // 申请人
    private String updater;

    // 申请时间
    private String updateDatetime;

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    // 账号
    private String accountNumber;

    // 手机号
    private String mobile;

    // 真实姓名
    private String realName;

    public String getHlNo() {
        return hlNo;
    }

    public void setHlNo(String hlNo) {
        this.hlNo = hlNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(String updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

}

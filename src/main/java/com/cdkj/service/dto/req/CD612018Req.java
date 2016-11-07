package com.cdkj.service.dto.req;

public class CD612018Req {

    // 服务编号 (必填)
    private String code;

    // 是否热门 (必填)
    private String isHot;

    // 序号 (选填)
    private String orderNo;

    // 处理人 (必填)
    private String dealer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIsHot() {
        return isHot;
    }

    public void setIsHot(String isHot) {
        this.isHot = isHot;
    }

    public String getDealer() {
        return dealer;
    }

    public void setDealer(String dealer) {
        this.dealer = dealer;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

}

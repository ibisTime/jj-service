package com.cdkj.service.dto.req;

public class XN612187Req {

    // 用户编号 (必填)
    private String publisher;

    // 状态 (选填)
    private String status;

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

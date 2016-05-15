package com.xnjr.mall.dto.req;

public class XNgs4003Req extends APageReq {
    // 名称（选填）
    private String name;

    // 状态（选填）
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

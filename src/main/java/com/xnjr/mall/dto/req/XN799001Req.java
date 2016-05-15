package com.xnjr.mall.dto.req;

public class XN799001Req {
    // 接受短信的手机号--必填
    private String mobile;

    // 短信内容--必填
    private String content;

    // 业务类型--必填
    private String bizType;

    // 备注--非必填
    private String remark;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

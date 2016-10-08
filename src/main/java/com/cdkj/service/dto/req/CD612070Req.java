package com.cdkj.service.dto.req;

public class CD612070Req extends APageReq {

    private static final long serialVersionUID = 1L;

    // 手机号 (选填)
    private String mobile;

    // 期望职位 (选填)
    private String expPosition;

    // 期望省份 (选填)
    private String expProvince;

    // 期望城市 (选填)
    private String expCity;

    // 发布人编号(选填)
    private String publisher;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getExpPosition() {
        return expPosition;
    }

    public void setExpPosition(String expPosition) {
        this.expPosition = expPosition;
    }

    public String getExpProvince() {
        return expProvince;
    }

    public void setExpProvince(String expProvince) {
        this.expProvince = expProvince;
    }

    public String getExpCity() {
        return expCity;
    }

    public void setExpCity(String expCity) {
        this.expCity = expCity;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

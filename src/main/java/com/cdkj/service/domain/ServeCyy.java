package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServeCyy extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private Long bgArea;

    private Long availBgArea;

    private Long ccArea;

    private Long availCcArea;

    private String zzfw;

    private String introduce;

    private String yhPolicy;

    private String pic1;

    private String pic2;

    private String description;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public Long getBgArea() {
        return bgArea;
    }

    public void setBgArea(Long bgArea) {
        this.bgArea = bgArea;
    }

    public Long getAvailBgArea() {
        return availBgArea;
    }

    public void setAvailBgArea(Long availBgArea) {
        this.availBgArea = availBgArea;
    }

    public Long getCcArea() {
        return ccArea;
    }

    public void setCcArea(Long ccArea) {
        this.ccArea = ccArea;
    }

    public Long getAvailCcArea() {
        return availCcArea;
    }

    public void setAvailCcArea(Long availCcArea) {
        this.availCcArea = availCcArea;
    }

    public String getZzfw() {
        return zzfw;
    }

    public void setZzfw(String zzfw) {
        this.zzfw = zzfw;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getYhPolicy() {
        return yhPolicy;
    }

    public void setYhPolicy(String yhPolicy) {
        this.yhPolicy = yhPolicy;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

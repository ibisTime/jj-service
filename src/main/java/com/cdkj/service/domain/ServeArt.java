package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServeArt extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private int designNum;

    private String sclm;

    private int homeDays;

    private Long homePrice;

    private int detailDays;

    private Long detailPrice;

    private int bannerDays;

    private Long bannerPrice;

    private int allDays;

    private Long allPrice;

    private String works;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public int getDesignNum() {
        return designNum;
    }

    public void setDesignNum(int designNum) {
        this.designNum = designNum;
    }

    public String getSclm() {
        return sclm;
    }

    public void setSclm(String sclm) {
        this.sclm = sclm;
    }

    public int getHomeDays() {
        return homeDays;
    }

    public void setHomeDays(int homeDays) {
        this.homeDays = homeDays;
    }

    public Long getHomePrice() {
        return homePrice;
    }

    public void setHomePrice(Long homePrice) {
        this.homePrice = homePrice;
    }

    public int getDetailDays() {
        return detailDays;
    }

    public void setDetailDays(int detailDays) {
        this.detailDays = detailDays;
    }

    public Long getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(Long detailPrice) {
        this.detailPrice = detailPrice;
    }

    public int getBannerDays() {
        return bannerDays;
    }

    public void setBannerDays(int bannerDays) {
        this.bannerDays = bannerDays;
    }

    public Long getBannerPrice() {
        return bannerPrice;
    }

    public void setBannerPrice(Long bannerPrice) {
        this.bannerPrice = bannerPrice;
    }

    public int getAllDays() {
        return allDays;
    }

    public void setAllDays(int allDays) {
        this.allDays = allDays;
    }

    public Long getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(Long allPrice) {
        this.allPrice = allPrice;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

}

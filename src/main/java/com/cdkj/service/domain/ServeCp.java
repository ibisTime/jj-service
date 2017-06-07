package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServeCp extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private int ckNum;

    private String ckArea;

    private String goodsKind;

    private int dsendNum;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public String getCkArea() {
        return ckArea;
    }

    public void setCkArea(String ckArea) {
        this.ckArea = ckArea;
    }

    public String getGoodsKind() {
        return goodsKind;
    }

    public void setGoodsKind(String goodsKind) {
        this.goodsKind = goodsKind;
    }

    public int getCkNum() {
        return ckNum;
    }

    public void setCkNum(int ckNum) {
        this.ckNum = ckNum;
    }

    public int getDsendNum() {
        return dsendNum;
    }

    public void setDsendNum(int dsendNum) {
        this.dsendNum = dsendNum;
    }

}

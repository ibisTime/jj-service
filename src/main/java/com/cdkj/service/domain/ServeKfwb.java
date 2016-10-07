package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServeKfwb extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private int kfNum;

    private String mtradeAmount;

    private String business;

    private String feeMode;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public int getKfNum() {
        return kfNum;
    }

    public void setKfNum(int kfNum) {
        this.kfNum = kfNum;
    }

    public String getMtradeAmount() {
        return mtradeAmount;
    }

    public void setMtradeAmount(String mtradeAmount) {
        this.mtradeAmount = mtradeAmount;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }
}

package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServeShop extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private String tgfw;

    private String feeMode;

    private String payCycle;

    private String scyylm;

    private String sucCase;

    private Serve serve;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public String getTgfw() {
        return tgfw;
    }

    public void setTgfw(String tgfw) {
        this.tgfw = tgfw;
    }

    public String getFeeMode() {
        return feeMode;
    }

    public void setFeeMode(String feeMode) {
        this.feeMode = feeMode;
    }

    public String getPayCycle() {
        return payCycle;
    }

    public void setPayCycle(String payCycle) {
        this.payCycle = payCycle;
    }

    public String getScyylm() {
        return scyylm;
    }

    public void setScyylm(String scyylm) {
        this.scyylm = scyylm;
    }

    public String getSucCase() {
        return sucCase;
    }

    public void setSucCase(String sucCase) {
        this.sucCase = sucCase;
    }

    public Serve getServe() {
        return serve;
    }

    public void setServe(Serve serve) {
        this.serve = serve;
    }
}

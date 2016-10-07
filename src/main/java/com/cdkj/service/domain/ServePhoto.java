package com.cdkj.service.domain;

import com.cdkj.service.dao.base.ABaseDO;

public class ServePhoto extends ABaseDO {

    private static final long serialVersionUID = 1L;

    private String serveCode;

    private int pyNum;

    private int sysNum;

    private String isDz;

    private String scpslm;

    private String works;

    private Serve serve;

    public String getServeCode() {
        return serveCode;
    }

    public void setServeCode(String serveCode) {
        this.serveCode = serveCode;
    }

    public int getPyNum() {
        return pyNum;
    }

    public void setPyNum(int pyNum) {
        this.pyNum = pyNum;
    }

    public int getSysNum() {
        return sysNum;
    }

    public void setSysNum(int sysNum) {
        this.sysNum = sysNum;
    }

    public String getIsDz() {
        return isDz;
    }

    public void setIsDz(String isDz) {
        this.isDz = isDz;
    }

    public String getScpslm() {
        return scpslm;
    }

    public void setScpslm(String scpslm) {
        this.scpslm = scpslm;
    }

    public String getWorks() {
        return works;
    }

    public void setWorks(String works) {
        this.works = works;
    }

    public Serve getServe() {
        return serve;
    }

    public void setServe(Serve serve) {
        this.serve = serve;
    }
}

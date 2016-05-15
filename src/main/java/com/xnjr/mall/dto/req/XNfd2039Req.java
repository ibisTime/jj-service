package com.xnjr.mall.dto.req;

public class XNfd2039Req {

    // 公司编号（必填）
    private String code;

    // KYC用户（必填）
    private String kycUser;

    // KYC结果（必填）1=通过；0=不通过
    private String kycResult;

    // KYC结果说明（必填）
    private String kycNote;

    // --Kyc通过的话，以下字段则必须start---
    // 拥有的服务list
    private String serveList;

    // 拥有的报价list
    private String quoteList;

    // 用户等级
    private String level;

    // --Kyc通过的话，以下字段则必须end---

    public String getKycUser() {
        return kycUser;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setKycUser(String kycUser) {
        this.kycUser = kycUser;
    }

    public String getKycResult() {
        return kycResult;
    }

    public void setKycResult(String kycResult) {
        this.kycResult = kycResult;
    }

    public String getKycNote() {
        return kycNote;
    }

    public void setKycNote(String kycNote) {
        this.kycNote = kycNote;
    }

    public String getServeList() {
        return serveList;
    }

    public void setServeList(String serveList) {
        this.serveList = serveList;
    }

    public String getQuoteList() {
        return quoteList;
    }

    public void setQuoteList(String quoteList) {
        this.quoteList = quoteList;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}

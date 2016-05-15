package com.xnjr.mall.dto.req;

import java.util.Date;

public class XNpt4000Req {

    // 公司编号（必填）
    private String companyCode;

    // 开户支行（必填）
    private String subbranchCode;

    // 账户性质（必填）
    private String kind;

    // 币种（必填）
    private String currency;

    // 账户编号（必填）
    private String cardNo;

    // 额度描述（必填）
    private String limitDescription;

    // 是否开通网银（必填）
    private String isEbank;

    // 是否开通电票（必填）
    private String isEticket;

    // 回单方式（必填）
    private String hdWay;

    // 回单邮寄地址
    private String hdAddress;

    // 回单卡密码
    private String hdCardPwd;

    // 回单账户密码
    private String hdAccountPwd;

    // 余额对账方式（必填）
    private String yedzdWay;

    // 余额对账单邮寄地址
    private String yedzdAddress;

    // 余额对账单账户密码
    private String yedzdAccountPwd;

    // 流水对账单方式（必填）
    private String lsdzdWay;

    // 流水对账单邮寄地址
    private String lsdzdAddress;

    // 流水对账单账户密码
    private String lsdzdAccountPwd;

    // 柜台联系人（必填）
    private String gtPerson;

    // 柜台联系方式（必填）
    private String gtContact;

    // 开户人（必填）
    private String khPerson;

    // 开户时间（必填）
    private String khDatetime;

    // 开户回执单（必填）
    private String pdf;

    // 最后一次流水更新时间（必填）
    private Date jourDatetime;

    // 更新人（必填）
    private String updater;

    // 备注
    private String remark;

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getSubbranchCode() {
        return subbranchCode;
    }

    public void setSubbranchCode(String subbranchCode) {
        this.subbranchCode = subbranchCode;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getLimitDescription() {
        return limitDescription;
    }

    public void setLimitDescription(String limitDescription) {
        this.limitDescription = limitDescription;
    }

    public String getIsEbank() {
        return isEbank;
    }

    public void setIsEbank(String isEbank) {
        this.isEbank = isEbank;
    }

    public String getIsEticket() {
        return isEticket;
    }

    public void setIsEticket(String isEticket) {
        this.isEticket = isEticket;
    }

    public String getHdWay() {
        return hdWay;
    }

    public void setHdWay(String hdWay) {
        this.hdWay = hdWay;
    }

    public String getHdAddress() {
        return hdAddress;
    }

    public void setHdAddress(String hdAddress) {
        this.hdAddress = hdAddress;
    }

    public String getHdCardPwd() {
        return hdCardPwd;
    }

    public void setHdCardPwd(String hdCardPwd) {
        this.hdCardPwd = hdCardPwd;
    }

    public String getHdAccountPwd() {
        return hdAccountPwd;
    }

    public void setHdAccountPwd(String hdAccountPwd) {
        this.hdAccountPwd = hdAccountPwd;
    }

    public String getYedzdWay() {
        return yedzdWay;
    }

    public void setYedzdWay(String yedzdWay) {
        this.yedzdWay = yedzdWay;
    }

    public String getYedzdAddress() {
        return yedzdAddress;
    }

    public void setYedzdAddress(String yedzdAddress) {
        this.yedzdAddress = yedzdAddress;
    }

    public String getYedzdAccountPwd() {
        return yedzdAccountPwd;
    }

    public void setYedzdAccountPwd(String yedzdAccountPwd) {
        this.yedzdAccountPwd = yedzdAccountPwd;
    }

    public String getLsdzdWay() {
        return lsdzdWay;
    }

    public void setLsdzdWay(String lsdzdWay) {
        this.lsdzdWay = lsdzdWay;
    }

    public String getLsdzdAddress() {
        return lsdzdAddress;
    }

    public void setLsdzdAddress(String lsdzdAddress) {
        this.lsdzdAddress = lsdzdAddress;
    }

    public String getLsdzdAccountPwd() {
        return lsdzdAccountPwd;
    }

    public void setLsdzdAccountPwd(String lsdzdAccountPwd) {
        this.lsdzdAccountPwd = lsdzdAccountPwd;
    }

    public String getGtPerson() {
        return gtPerson;
    }

    public void setGtPerson(String gtPerson) {
        this.gtPerson = gtPerson;
    }

    public String getGtContact() {
        return gtContact;
    }

    public void setGtContact(String gtContact) {
        this.gtContact = gtContact;
    }

    public String getKhPerson() {
        return khPerson;
    }

    public void setKhPerson(String khPerson) {
        this.khPerson = khPerson;
    }

    public String getKhDatetime() {
        return khDatetime;
    }

    public void setKhDatetime(String khDatetime) {
        this.khDatetime = khDatetime;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public Date getJourDatetime() {
        return jourDatetime;
    }

    public void setJourDatetime(Date jourDatetime) {
        this.jourDatetime = jourDatetime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}

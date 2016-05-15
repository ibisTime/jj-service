package com.xnjr.mall.dto.req;

/** 
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:41:02 
 * @history:
 */
public class XNfd2045Req {
    // 公司名字（必填）

    private String name;

    // 工商营业执照号（必填）

    private String gsyyzzNo;

    // 法人证件类型（必填）

    private String idKind;

    // 法人证件号码（必填）

    private String idNo;

    // 法人真实姓名（必填）

    private String realName;

    // 币种（必填）

    private String currency;

    // 注册资金（必填）

    private String capital;

    // 省（必填）

    private String province;

    // 市（必填）

    private String city;

    // 公司地址（选填）

    private String address;

    // 申请人（必填）

    private String applyUser;

    // 银行编号(必填)
    private String bankCode;

    // 支行(必填)
    private String subbranch;

    // 企业账号(必填)
    private String cardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGsyyzzNo() {
        return gsyyzzNo;
    }

    public void setGsyyzzNo(String gsyyzzNo) {
        this.gsyyzzNo = gsyyzzNo;
    }

    public String getIdKind() {
        return idKind;
    }

    public void setIdKind(String idKind) {
        this.idKind = idKind;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getSubbranch() {
        return subbranch;
    }

    public void setSubbranch(String subbranch) {
        this.subbranch = subbranch;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}

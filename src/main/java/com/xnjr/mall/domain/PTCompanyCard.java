/**
 * @Title PlatAccount.java 
 * @Package com.xnjr.moom.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年3月5日 上午10:42:43 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * 平台公司卡
 * @author: xieyj 
 * @since: 2016年3月5日 上午10:42:43 
 * @history:
 */
public class PTCompanyCard extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 5223241553508387459L;

    private Date KhDatetimeStart;

    private Date KhDatetimeEnd;

    // ************ db propertis **************
    // 编号
    private String code;

    // 公司编号
    private String companyCode;

    // 开户支行
    private String subbranchCode;

    // 账户性质
    private String kind;

    // 币种
    private String currency;

    // 账户余额（预留）
    private String amount;

    // 账户编号
    private String cardNo;

    // 额度描述
    private String limitDescription;

    // 是否开通网银
    private String isEbank;

    // 是否开通电票
    private String isEticket;

    // 回单方式
    private String hdWay;

    // 回单邮寄地址
    private String hdAddress;

    // 回单卡密码
    private String hdCardPwd;

    // 回单账户密码
    private String hdAccountPwd;

    // 余额对账方式
    private String yedzdWay;

    // 余额对账单邮寄地址
    private String yedzdAddress;

    // 余额对账单账户密码
    private String yedzdAccountPwd;

    // 流水对账单方式
    private String lsdzdWay;

    // 流水对账单邮寄地址
    private String lsdzdAddress;

    // 流水对账单账户密码
    private String lsdzdAccountPwd;

    // 柜台联系人
    private String gtPerson;

    // 柜台联系方式
    private String gtContact;

    // 开户人
    private String khPerson;

    // 开户时间
    private Date khDatetime;

    // 开户回执单
    private String pdf;

    // 最后一次流水更新时间
    private Date jourDatetime;

    // 状态
    private String status;

    // 是否受款
    private String isAccept;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ************ db propertis **************

    // 支行名称
    private String subbranchName;

    // 状态
    private String subbranchStatus;

    // 银行编号
    private String bankCode;

    // 银行名称
    private String bankName;

    // 所在地区
    private String region;

    // 所在地址
    private String address;

    // 中国现代化支付系统（CNAPS）号
    private String cnapsCode;

    // 银行国际代码
    private String swiftCode;

    // 客户经理
    private String khjlPerson;

    // 联系方式
    private String khjlContact;

    // 备注
    private String subbranchRemark;

    // ******* subbranch end company start*****

    // 公司名称
    private String zwName;

    // 英文名称
    private String ywName;

    // 注册地址
    private String zcAddress;

    // 经营地址
    private String jyAddress;

    // 币种
    private String gsCurrency;

    // 注册资本
    private String capital;

    // 法人
    private String frPerson;

    // 股东
    private String gdPerson;

    // 财务负责人
    private String cwPerson;

    // 大额变动提醒人
    private String debdtxPerson;

    // 网银录入人
    private String wyRecorder;

    // 网银审核人
    private String wyChecker;

    // 公司座机
    private String telephone;

    // 备注
    private String companyRemark;

    public Date getKhDatetimeStart() {
        return KhDatetimeStart;
    }

    public void setKhDatetimeStart(Date khDatetimeStart) {
        KhDatetimeStart = khDatetimeStart;
    }

    public Date getKhDatetimeEnd() {
        return KhDatetimeEnd;
    }

    public void setKhDatetimeEnd(Date khDatetimeEnd) {
        KhDatetimeEnd = khDatetimeEnd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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

    public Date getKhDatetime() {
        return khDatetime;
    }

    public void setKhDatetime(Date khDatetime) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsAccept() {
        return isAccept;
    }

    public void setIsAccept(String isAccept) {
        this.isAccept = isAccept;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSubbranchName() {
        return subbranchName;
    }

    public void setSubbranchName(String subbranchName) {
        this.subbranchName = subbranchName;
    }

    public String getSubbranchStatus() {
        return subbranchStatus;
    }

    public void setSubbranchstatus(String subbranchStatus) {
        this.subbranchStatus = subbranchStatus;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCnapsCode() {
        return cnapsCode;
    }

    public void setCnapsCode(String cnapsCode) {
        this.cnapsCode = cnapsCode;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getKhjlPerson() {
        return khjlPerson;
    }

    public void setKhjlPerson(String khjlPerson) {
        this.khjlPerson = khjlPerson;
    }

    public String getKhjlContact() {
        return khjlContact;
    }

    public void setKhjlContact(String khjlContact) {
        this.khjlContact = khjlContact;
    }

    public String getZwName() {
        return zwName;
    }

    public void setZwName(String zwName) {
        this.zwName = zwName;
    }

    public String getYwName() {
        return ywName;
    }

    public void setYwName(String ywName) {
        this.ywName = ywName;
    }

    public String getZcAddress() {
        return zcAddress;
    }

    public void setZcAddress(String zcAddress) {
        this.zcAddress = zcAddress;
    }

    public String getJyAddress() {
        return jyAddress;
    }

    public void setJyAddress(String jyAddress) {
        this.jyAddress = jyAddress;
    }

    public String getGsCurrency() {
        return gsCurrency;
    }

    public void setGsCurrency(String gsCurrency) {
        this.gsCurrency = gsCurrency;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getFrPerson() {
        return frPerson;
    }

    public void setFrPerson(String frPerson) {
        this.frPerson = frPerson;
    }

    public String getGdPerson() {
        return gdPerson;
    }

    public void setGdPerson(String gdPerson) {
        this.gdPerson = gdPerson;
    }

    public String getCwPerson() {
        return cwPerson;
    }

    public void setCwPerson(String cwPerson) {
        this.cwPerson = cwPerson;
    }

    public String getDebdtxPerson() {
        return debdtxPerson;
    }

    public void setDebdtxPerson(String debdtxPerson) {
        this.debdtxPerson = debdtxPerson;
    }

    public String getWyRecorder() {
        return wyRecorder;
    }

    public void setWyRecorder(String wyRecorder) {
        this.wyRecorder = wyRecorder;
    }

    public String getWyChecker() {
        return wyChecker;
    }

    public void setWyChecker(String wyChecker) {
        this.wyChecker = wyChecker;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCompanyRemark() {
        return companyRemark;
    }

    public void setCompanyRemark(String companyRemark) {
        this.companyRemark = companyRemark;
    }

    public void setSubbranchStatus(String subbranchStatus) {
        this.subbranchStatus = subbranchStatus;
    }

    public String getSubbranchRemark() {
        return subbranchRemark;
    }

    public void setSubbranchRemark(String subbranchRemark) {
        this.subbranchRemark = subbranchRemark;
    }

}

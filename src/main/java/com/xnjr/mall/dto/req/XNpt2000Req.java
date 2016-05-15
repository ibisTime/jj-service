/**
 * @Title XNpt2000Req.java 
 * @Package com.xnjr.moom.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:48:08 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:48:08 
 * @history:
 */
public class XNpt2000Req {

    // 公司名称（必填）
    private String zwName;

    // 英文名称（必填）
    private String ywName;

    // 注册地址（必填）
    private String zcAddress;

    // 经营地址（必填）
    private String jyAddress;

    // 币种（必填）
    private String currency;

    // 注册资本（必填）
    private String capital;

    // 法人（必填）
    private String frPerson;

    // 股东（必填）
    private String gdPerson;

    // 财务负责人（必填）
    private String cwPerson;

    // 大额变动提醒人（必填）
    private String debdtxPerson;

    // 网银录入人（必填）
    private String wyRecorder;

    // 网银审核人（必填）
    private String wyChecker;

    // 公司座机（必填）
    private String telephone;

    // 备注
    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

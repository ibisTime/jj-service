package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/**
 * 受款商户(merchant)账号
 * @author: xieyj 
 * @since: 2016年6月11日 下午4:06:15 
 * @history:
 */
public class MerCard extends ABaseDO {

    private static final long serialVersionUID = 4363569950942669917L;

    // 编号
    private String code;

    // 公司编号
    private String companyCode;

    // 支行
    private String subbranch;

    // 开户账号
    private String cardNo;

    // 状态
    private String status;

    // 更新时间
    private Date updateDatetime;

    // 更新人
    private String updater;

    // 备注
    private String remark;

    // ************* 模糊查询 *****************
    // 支行模糊查询
    private String subbranchForQuery;

    // 开户账号模糊查询
    private String cardNoForQuery;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
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

    public String getSubbranchForQuery() {
        return subbranchForQuery;
    }

    public void setSubbranchForQuery(String subbranchForQuery) {
        this.subbranchForQuery = subbranchForQuery;
    }

    public String getCardNoForQuery() {
        return cardNoForQuery;
    }

    public void setCardNoForQuery(String cardNoForQuery) {
        this.cardNoForQuery = cardNoForQuery;
    }
}

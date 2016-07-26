package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 上午8:28:23 
 * @history:
 */
public class BuyGuide extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 1L;

    // 编号
    private String code;

    // 原价
    private Long originalPrice;

    // 折扣价
    private Long discountPrice;

    // 受众
    private String toLevel;

    // 型号编号
    private String modelCode;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // 对应货品商
    private String fromUser;

    // 仓库数量
    private String fromQuantity;

    // 仓库位置（预留）
    private String fromSite;

    // 成本价
    private Date costPrice;

    // 线上位置
    private String toSite;

    // 状态
    private String status;

    // *************db properties**************
    // 型号名称
    private String modelName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Long getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Long discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getToLevel() {
        return toLevel;
    }

    public void setToLevel(String toLevel) {
        this.toLevel = toLevel;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getFromQuantity() {
        return fromQuantity;
    }

    public void setFromQuantity(String fromQuantity) {
        this.fromQuantity = fromQuantity;
    }

    public String getFromSite() {
        return fromSite;
    }

    public void setFromSite(String fromSite) {
        this.fromSite = fromSite;
    }

    public Date getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Date costPrice) {
        this.costPrice = costPrice;
    }

    public String getToSite() {
        return toSite;
    }

    public void setToSite(String toSite) {
        this.toSite = toSite;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

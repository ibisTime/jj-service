/**
 * @Title SaleGuide.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年7月25日 下午2:27:09 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年7月25日 下午2:27:09 
 * @history:
 */
public class SaleGuide extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 6426293086084585353L;

    // *************db properties **************
    // 编号
    private String code;

    // 型号编号
    private String modelCode;

    // 受众
    private String toLevel;

    // 数量
    private Long quantity;

    // 价格
    private Long price;

    // 更新人
    private String updater;

    // 更新时间
    private Date updateDatetime;

    // 备注
    private String remark;

    // ************* 前端显示字段 **************
    // 型号名称
    private String modelName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getToLevel() {
        return toLevel;
    }

    public void setToLevel(String toLevel) {
        this.toLevel = toLevel;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "SaleGuide [code=" + code + ", modelCode=" + modelCode
                + ", toLevel=" + toLevel + ", quantity=" + quantity
                + ", price=" + price + ", updater=" + updater
                + ", updateDatetime=" + updateDatetime + ", remark=" + remark
                + ", modelName=" + modelName + "]";
    }
}

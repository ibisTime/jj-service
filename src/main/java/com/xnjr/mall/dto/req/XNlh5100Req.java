package com.xnjr.mall.dto.req;

/**
 * 新增分销引导表Req
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:05:36 
 * @history:
 */
public class XNlh5100Req {

    // 型号编号(必填)
    private String modelCode;

    // 用户等级(必填)
    private String toLevel;

    // 数量(必填)
    private String quantity;

    // 成本价(必填)
    private String price;

    // 更新人(必填)
    private String updater;

    // 备注(必填)
    private String remark;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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

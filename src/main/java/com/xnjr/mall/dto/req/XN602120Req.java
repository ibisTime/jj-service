package com.xnjr.mall.dto.req;

public class XN602120Req {
    // 货品编号(必填)
    private String goodsCode;

    // 单价(必填)
    private String price;

    // 数量(必填)
    private String quantity;

    // 申请人(必填)
    private String applyUser;

    // 申请备注(选填)
    private String applyNote;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }
}

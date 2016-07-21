package com.xnjr.mall.domain;

import java.util.Date;

import com.xnjr.mall.dao.base.ABaseDO;

public class GoodsOrder extends ABaseDO {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 44963193311467476L;

    // 编号
    private String code;

    // 货品编号
    private String goodsCode;

    // 单价
    private String price;

    // 数量
    private String quantity;

    // 状态、0 待发布 1已发布，2已过期
    private String status;

    // 申请人
    private String applyUser;

    // 申请时间
    private Date applyDatetime;

    // 申请备注
    private String applyNote;

    // 审核人
    private String approveUser;

    // 审核时间
    private Date approveDatetime;

    // 审核说明
    private String approveNote;

    // *************dp properties **************

    // 申请开始时间起
    private Date applyDatetimeStart;

    // 申请开始时间止
    private Date applyDatetimeEnd;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Date getApplyDatetime() {
        return applyDatetime;
    }

    public void setApplyDatetime(Date applyDatetime) {
        this.applyDatetime = applyDatetime;
    }

    public String getApplyNote() {
        return applyNote;
    }

    public void setApplyNote(String applyNote) {
        this.applyNote = applyNote;
    }

    public String getApproveUser() {
        return approveUser;
    }

    public void setApproveUser(String approveUser) {
        this.approveUser = approveUser;
    }

    public Date getApproveDatetime() {
        return approveDatetime;
    }

    public void setApproveDatetime(Date approveDatetime) {
        this.approveDatetime = approveDatetime;
    }

    public String getApproveNote() {
        return approveNote;
    }

    public void setApproveNote(String approveNote) {
        this.approveNote = approveNote;
    }

    public Date getApplyDatetimeStart() {
        return applyDatetimeStart;
    }

    public void setApplyDatetimeStart(Date applyDatetimeStart) {
        this.applyDatetimeStart = applyDatetimeStart;
    }

    public Date getApplyDatetimeEnd() {
        return applyDatetimeEnd;
    }

    public void setApplyDatetimeEnd(Date applyDatetimeEnd) {
        this.applyDatetimeEnd = applyDatetimeEnd;
    }

}

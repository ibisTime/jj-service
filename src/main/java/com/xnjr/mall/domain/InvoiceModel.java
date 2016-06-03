/**
 * @Title Invoice.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 下午7:32:38 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 下午7:32:38 
 * @history:
 */
public class InvoiceModel extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -6380104639754144884L;

    // 编号
    private String code;

    // 订单编号
    private String invoiceCode;

    // 型号编号
    private String modelCode;

    // 数量
    private Integer quantity;

    // 单价
    private Long salePrice;

    // **************db properties
    // 型号名称
    private String modelName;

    // 产品编号
    private String productCode;

    // 产品名称
    private String productName;

    // pic1
    private String pic1;

    // pic2
    private String pic2;

    // pic3
    private String pic3;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPic1() {
        return pic1;
    }

    public void setPic1(String pic1) {
        this.pic1 = pic1;
    }

    public String getPic2() {
        return pic2;
    }

    public void setPic2(String pic2) {
        this.pic2 = pic2;
    }

    public String getPic3() {
        return pic3;
    }

    public void setPic3(String pic3) {
        this.pic3 = pic3;
    }
}

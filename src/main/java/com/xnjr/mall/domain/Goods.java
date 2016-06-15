/**
 * @Title Goods.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 上午11:15:16 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 上午11:15:16 
 * @history:
 */
public class Goods extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = 8580139290108417774L;

    // 主键PK
    private String code;

    // 成本价
    private Long costPrice;

    // 实际销售价
    private Long salePrice;

    // 对应的型号编号
    private String modelCode;

    // 所属物流单号
    private String logisticsCode;

    // 所属用户ID
    private String userId;

    /**** 显示字段 ****/
    private String modelName;

    private String productName;

    /**** 物流信息录入辅助字段 ****/
    // 数量
    private Long quantity;

    private String codeStart;

    private String codeEnd;

    private String codeForLikeQuery;

    private String modelCodeForLikeQuery;

    private String logisticsCodeForLikeQuery;

    // 物流单状态
    private String status;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Long costPrice) {
        this.costPrice = costPrice;
    }

    public Long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Long salePrice) {
        this.salePrice = salePrice;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getCodeStart() {
        return codeStart;
    }

    public void setCodeStart(String codeStart) {
        this.codeStart = codeStart;
    }

    public String getCodeEnd() {
        return codeEnd;
    }

    public void setCodeEnd(String codeEnd) {
        this.codeEnd = codeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodeForLikeQuery() {
        return codeForLikeQuery;
    }

    public void setCodeForLikeQuery(String codeForLikeQuery) {
        this.codeForLikeQuery = codeForLikeQuery;
    }

    public String getModelCodeForLikeQuery() {
        return modelCodeForLikeQuery;
    }

    public void setModelCodeForLikeQuery(String modelCodeForLikeQuery) {
        this.modelCodeForLikeQuery = modelCodeForLikeQuery;
    }

    public String getLogisticsCodeForLikeQuery() {
        return logisticsCodeForLikeQuery;
    }

    public void setLogisticsCodeForLikeQuery(String logisticsCodeForLikeQuery) {
        this.logisticsCodeForLikeQuery = logisticsCodeForLikeQuery;
    }
}

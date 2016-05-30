/**
 * @Title Logistics.java 
 * @Package com.xnjr.mall.domain 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 上午11:11:18 
 * @version V1.0   
 */
package com.xnjr.mall.domain;

import java.util.Date;
import java.util.List;

import com.xnjr.mall.dao.base.ABaseDO;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 上午11:11:18 
 * @history:
 */
public class Logistics extends ABaseDO {
    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -3096524718049819002L;

    // 物流单号
    private String code;

    // 关联的发货单号
    private String invoiceCode;

    // 物流公司
    private String company;

    // 发货时间
    private Date deliveryDatetime;

    // 发货人
    private String deliverer;

    // 下单用户
    private String userId;

    /***** 查询条件 *****/
    // 发货时间起
    private Date deliveryDatetimeStart;

    // 发货时间止
    private Date deliveryDatetimeEnd;

    /***** 关联信息 *****/
    private List<Goods> goodsList;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDeliveryDatetime() {
        return deliveryDatetime;
    }

    public void setDeliveryDatetime(Date deliveryDatetime) {
        this.deliveryDatetime = deliveryDatetime;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getDeliveryDatetimeStart() {
        return deliveryDatetimeStart;
    }

    public void setDeliveryDatetimeStart(Date deliveryDatetimeStart) {
        this.deliveryDatetimeStart = deliveryDatetimeStart;
    }

    public Date getDeliveryDatetimeEnd() {
        return deliveryDatetimeEnd;
    }

    public void setDeliveryDatetimeEnd(Date deliveryDatetimeEnd) {
        this.deliveryDatetimeEnd = deliveryDatetimeEnd;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

}

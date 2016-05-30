/**
 * @Title XN602040Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:21:20 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

import java.util.List;

import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:21:20 
 * @history:
 */
public class XN602040Req {

    // 物流单号
    private String code;

    // 关联的发货单号
    private String invoiceCode;

    // 物流公司
    private String company;

    // 发货时间
    private String deliveryDatetime;

    // 发货人
    private String deliverer;

    // 货品信息
    private List<Goods> goodsList;

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDeliveryDatetime() {
        return deliveryDatetime;
    }

    public void setDeliveryDatetime(String deliveryDatetime) {
        this.deliveryDatetime = deliveryDatetime;
    }

    public String getDeliverer() {
        return deliverer;
    }

    public void setDeliverer(String deliverer) {
        this.deliverer = deliverer;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}

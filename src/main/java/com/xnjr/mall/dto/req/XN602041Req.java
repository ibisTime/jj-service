/**
 * @Title XN602041Req.java 
 * @Package com.xnjr.mall.dto.req 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:23:59 
 * @version V1.0   
 */
package com.xnjr.mall.dto.req;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:23:59 
 * @history:
 */
public class XN602041Req extends APageReq {

    /** 
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
     */
    private static final long serialVersionUID = -4700855033513054506L;

    // 物流单号
    private String code;

    // 关联的发货单号
    private String invoiceCode;

    // 发货时间起
    private String deliveryDatetimeStart;

    // 发货时间止
    private String deliveryDatetimeEnd;

    // 发货人
    private String deliverer;

    // 下单用户
    private String userId;

    // 状态
    private String status;

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

    public String getDeliveryDatetimeStart() {
        return deliveryDatetimeStart;
    }

    public void setDeliveryDatetimeStart(String deliveryDatetimeStart) {
        this.deliveryDatetimeStart = deliveryDatetimeStart;
    }

    public String getDeliveryDatetimeEnd() {
        return deliveryDatetimeEnd;
    }

    public void setDeliveryDatetimeEnd(String deliveryDatetimeEnd) {
        this.deliveryDatetimeEnd = deliveryDatetimeEnd;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

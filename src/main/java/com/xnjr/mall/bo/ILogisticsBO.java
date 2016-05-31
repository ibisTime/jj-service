/**
 * @Title ILogisticsBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午12:50:56 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Logistics;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午12:50:56 
 * @history:
 */
public interface ILogisticsBO extends IPaginableBO<Logistics> {
    public String saveLogistics(Logistics data);

    public Logistics getLogistics(String code);

    /**
     * 根据发货单编号查询物流信息
     * @param invoiceCode
     * @return 
     * @create: 2016年5月31日 下午1:36:45 haiqingzheng
     * @history:
     */
    public Logistics getLogisticsByInvoiceCode(String invoiceCode);
}

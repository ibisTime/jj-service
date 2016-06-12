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

    /**
     * 判断物流单是否存在
     * @param code
     * @return 
     * @create: 2016年6月12日 上午8:46:46 xieyj
     * @history:
     */
    public boolean isLogisticsExist(String code);

    /**
     * 录入物流单
     * @param data
     * @return 
     * @create: 2016年6月12日 上午8:45:20 xieyj
     * @history:
     */
    public String saveLogistics(Logistics data);

    /**
     * @param code
     * @return 
     * @create: 2016年6月12日 上午8:46:19 xieyj
     * @history:
     */
    public Logistics getLogistics(String code);

    /**
     * 根据发货单编号查询物流信息
     * @param invoiceCode
     * @return 
     * @create: 2016年5月31日 下午1:36:45 haiqingzheng
     * @history:
     */
    public Logistics getLogisticsByInvoiceCode(String invoiceCode);

    /**
     * 物流确认
     * @param code
     * @param updater
     * @param remark 
     * @create: 2016年6月11日 下午10:19:01 xieyj
     * @history:
     */
    public int refreshLogisticsStatus(String code, String updater, String remark);
}

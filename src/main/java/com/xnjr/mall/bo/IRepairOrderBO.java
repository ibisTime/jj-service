/**
 * @Title IRepairOrderBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:06:58 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.RepairOrder;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:06:58 
 * @history:
 */
public interface IRepairOrderBO extends IPaginableBO<RepairOrder> {

    public String saveRepairOrder(RepairOrder data);

    public RepairOrder getRepairOrder(String code);

    public int refreshStatus(String code, String status, String updater,
            String remark);
}

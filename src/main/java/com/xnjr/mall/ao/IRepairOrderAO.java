/**
 * @Title IRepairOrderAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:31:23 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.RepairOrder;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:31:23 
 * @history:
 */
public interface IRepairOrderAO {

    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addRepairOrder(RepairOrder data);

    public Paginable<RepairOrder> queryRepairOrderPage(int start, int limit,
            RepairOrder condition);

    public RepairOrder getRepairOrder(String code);

    public int dealWithRepairOrder(String code, String checkResult,
            String checkUser, String remark);
}

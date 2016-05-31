/**
 * @Title RepairOrderBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:10:09 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IRepairOrderBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IRepairOrderDAO;
import com.xnjr.mall.domain.RepairOrder;
import com.xnjr.mall.enums.ERepairOrderStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:10:09 
 * @history:
 */
@Component
public class RepairOrderBOImpl extends PaginableBOImpl<RepairOrder> implements
        IRepairOrderBO {

    @Autowired
    IRepairOrderDAO repairOrderDAO;

    /** 
     * @see com.xnjr.mall.bo.IRepairOrderBO#saveRepairOrder(com.xnjr.mall.domain.RepairOrder)
     */
    @Override
    public String saveRepairOrder(RepairOrder data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("WXD");
            data.setCode(code);
            data.setApplyDatetime(new Date());
            data.setStatus(ERepairOrderStatus.NEW.getCode());
            repairOrderDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IRepairOrderBO#getRepairOrder(java.lang.String)
     */
    @Override
    public RepairOrder getRepairOrder(String code) {
        RepairOrder repairOrder = null;
        if (StringUtils.isNotBlank(code)) {
            RepairOrder condition = new RepairOrder();
            condition.setCode(code);
            repairOrder = repairOrderDAO.select(condition);
            if (repairOrder == null) {
                throw new BizException("xn000000", "维修单号不存在");
            }
        }
        return repairOrder;
    }

    /** 
     * @see com.xnjr.mall.bo.IRepairOrderBO#refreshStatus(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshStatus(String code, String status, String updater,
            String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(status)
                && StringUtils.isNotBlank(updater)) {
            RepairOrder data = new RepairOrder();
            data.setCode(code);
            data.setStatus(status);
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = repairOrderDAO.updateStatus(data);
        }
        return count;
    }

}

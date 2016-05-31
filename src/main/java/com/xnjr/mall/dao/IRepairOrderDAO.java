/**
 * @Title IRepairOrderDAO.java 
 * @Package com.xnjr.mall.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午2:07:22 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.RepairOrder;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午2:07:22 
 * @history:
 */
public interface IRepairOrderDAO extends IBaseDAO<RepairOrder> {
    String NAMESPACE = IRepairOrderDAO.class.getName().concat(".");

    /**
     * 更新维修单状态
     * @param data
     * @return 
     * @create: 2016年5月31日 下午3:00:24 haiqingzheng
     * @history:
     */
    public int updateStatus(RepairOrder data);
}

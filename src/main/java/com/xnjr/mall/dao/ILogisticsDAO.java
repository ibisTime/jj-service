/**
 * @Title ILogisticsDAO.java 
 * @Package com.xnjr.mall.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 上午11:22:01 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Logistics;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 上午11:22:01 
 * @history:
 */
public interface ILogisticsDAO extends IBaseDAO<Logistics> {
    String NAMESPACE = ILogisticsDAO.class.getName().concat(".");
}

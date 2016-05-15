/**
 * @Title ISYSLogDAO.java 
 * @Package com.xnjr.moom.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午8:29:44 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.SYSLog;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午8:29:44 
 * @history:
 */
public interface ISYSLogDAO extends IBaseDAO<SYSLog> {
    String NAMESPACE = ISYSLogDAO.class.getName().concat(".");
}

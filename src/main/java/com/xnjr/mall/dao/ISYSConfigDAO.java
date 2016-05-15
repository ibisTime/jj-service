/**
 * @Title ISYSConfigDAO.java 
 * @Package com.xnjr.moom.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月17日 上午10:19:51 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.SYSConfig;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月17日 上午10:19:51 
 * @history:
 */
public interface ISYSConfigDAO extends IBaseDAO<SYSConfig> {
    String NAMESPACE = ISYSConfigDAO.class.getName().concat(".");

    public int updateValue(SYSConfig data);
}

/**
 * @Title ISaleGuideDAO.java 
 * @Package com.xnjr.mall.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年7月25日 下午2:32:13 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.SaleGuide;

/** 
 * @author: haiqingzheng 
 * @since: 2016年7月25日 下午2:32:13 
 * @history:
 */
public interface ISaleGuideDAO extends IBaseDAO<SaleGuide> {
    String NAMESPACE = ISaleGuideDAO.class.getName().concat(".");

    /**
     * 修改
     * @param data
     * @return 
     * @create: 2016年7月25日 下午3:02:33 haiqingzheng
     * @history:
     */
    public int update(SaleGuide data);
}

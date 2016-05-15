/**
 * @Title IPTCompanyDAO.java 
 * @Package com.xnjr.moom.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午7:54:59 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.PTCompany;

/** 
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午7:54:59 
 * @history:
 */
public interface IPTCompanyDAO extends IBaseDAO<PTCompany> {
    String NAMESPACE = IPTCompanyDAO.class.getName().concat(".");

    /**
     * 更新平台公司
     * @param data
     * @return 
     * @create: 2016年3月4日 下午8:30:00 haiqingzheng
     * @history:
     */
    public int updatePTCompany(PTCompany data);
}

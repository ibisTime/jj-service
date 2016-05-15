package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Business;

/**
 * 业务
 * @author: xieyj 
 * @since: 2016年1月17日 上午10:44:37 
 * @history:
 */
public interface IBusinessDAO extends IBaseDAO<Business> {
    String NAMESPACE = IBusinessDAO.class.getName().concat(".");

    public int unpassBusiness(Business business);

    public int passBusiness(Business business);

    public int updateBusiness(Business business);

    public int updateContract(Business business);
}

package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.BusinessTable;

/**
 * 业务核算
 * @author: xieyj 
 * @since: 2016年1月17日 上午10:44:37 
 * @history:
 */
public interface IBusinessTableDAO extends IBaseDAO<BusinessTable> {
    String NAMESPACE = IBusinessTableDAO.class.getName().concat(".");

    public int deleteBusinessTable(BusinessTable condition);
}

package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Demand;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:05:32 
 * @history:
 */
public interface IDemandDAO extends IBaseDAO<Demand> {
    String NAMESPACE = IDemandDAO.class.getName().concat(".");

    public int updateStatus(Demand data);
}

package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServeCp;

public interface IServeCpDAO extends IBaseDAO<ServeCp> {
    String NAMESPACE = IServeCpDAO.class.getName().concat(".");

    public int update(ServeCp data);
}

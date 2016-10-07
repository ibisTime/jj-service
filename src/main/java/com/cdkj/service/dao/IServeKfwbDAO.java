package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServeKfwb;

public interface IServeKfwbDAO extends IBaseDAO<ServeKfwb> {
    String NAMESPACE = IServeKfwbDAO.class.getName().concat(".");

    public int update(ServeKfwb data);
}

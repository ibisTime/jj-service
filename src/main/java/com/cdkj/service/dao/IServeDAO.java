package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Serve;

public interface IServeDAO extends IBaseDAO<Serve> {
    String NAMESPACE = IServeDAO.class.getName().concat(".");
}

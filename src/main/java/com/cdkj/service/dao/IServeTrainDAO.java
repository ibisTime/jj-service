package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServeTrain;

public interface IServeTrainDAO extends IBaseDAO<ServeTrain> {
    String NAMESPACE = IServeTrainDAO.class.getName().concat(".");
}

package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Intention;

public interface IIntentionDAO extends IBaseDAO<Intention> {
    String NAMESPACE = IIntentionDAO.class.getName().concat(".");

    public int updateStatus(Intention data);
}

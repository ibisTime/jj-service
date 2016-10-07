package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServeArt;

public interface IServeArtDAO extends IBaseDAO<ServeArt> {
    String NAMESPACE = IServeArtDAO.class.getName().concat(".");

    public int update(ServeArt data);
}

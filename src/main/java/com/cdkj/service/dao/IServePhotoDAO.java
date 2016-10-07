package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServePhoto;

public interface IServePhotoDAO extends IBaseDAO<ServePhoto> {
    String NAMESPACE = IServePhotoDAO.class.getName().concat(".");
}

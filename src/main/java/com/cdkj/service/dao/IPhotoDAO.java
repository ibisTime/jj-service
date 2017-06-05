package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Photo;

//dao层 
public interface IPhotoDAO extends IBaseDAO<Photo> {
	String NAMESPACE = IPhotoDAO.class.getName().concat(".");
}
package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.GsQualify;

//dao层 
public interface IGsQualifyDAO extends IBaseDAO<GsQualify> {
	String NAMESPACE = IGsQualifyDAO.class.getName().concat(".");
}
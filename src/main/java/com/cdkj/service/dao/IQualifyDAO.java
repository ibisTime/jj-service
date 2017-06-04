package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Qualify;

//dao层 
public interface IQualifyDAO extends IBaseDAO<Qualify> {
	String NAMESPACE = IQualifyDAO.class.getName().concat(".");
}
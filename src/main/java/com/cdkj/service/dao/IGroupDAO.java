package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Group;

//dao层 
public interface IGroupDAO extends IBaseDAO<Group> {
	String NAMESPACE = IGroupDAO.class.getName().concat(".");
}
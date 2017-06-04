package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Focus;

//dao层 
public interface IFocusDAO extends IBaseDAO<Focus> {
	String NAMESPACE = IFocusDAO.class.getName().concat(".");
}
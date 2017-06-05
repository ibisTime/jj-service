package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Company;

//dao层 
public interface ICompanyDAO extends IBaseDAO<Company> {
	String NAMESPACE = ICompanyDAO.class.getName().concat(".");
}
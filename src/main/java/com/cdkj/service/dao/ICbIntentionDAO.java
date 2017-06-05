package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.CbIntention;

//dao层 
public interface ICbIntentionDAO extends IBaseDAO<CbIntention> {
	String NAMESPACE = ICbIntentionDAO.class.getName().concat(".");
}
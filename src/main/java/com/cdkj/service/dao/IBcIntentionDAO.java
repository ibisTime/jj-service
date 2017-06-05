package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.BcIntention;

//dao层 
public interface IBcIntentionDAO extends IBaseDAO<BcIntention> {
	String NAMESPACE = IBcIntentionDAO.class.getName().concat(".");
}
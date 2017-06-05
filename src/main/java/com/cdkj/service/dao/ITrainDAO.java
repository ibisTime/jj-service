package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Train;

//dao层 
public interface ITrainDAO extends IBaseDAO<Train> {
	String NAMESPACE = ITrainDAO.class.getName().concat(".");
}
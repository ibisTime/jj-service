package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.ServeTrain;

//CHECK ¼ì²é²¢¼Ó×¢ÊÍ 
public interface IServeTrainDAO extends IBaseDAO<ServeTrain> {
	String NAMESPACE = IServeTrainDAO.class.getName().concat(".");

	public int update(ServeTrain data);
}
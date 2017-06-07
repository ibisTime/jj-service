package com.cdkj.service.dao;

import com.cdkj.service.dao.base.IBaseDAO;
import com.cdkj.service.domain.Operate;

//dao层 
public interface IOperateDAO extends IBaseDAO<Operate> {
    String NAMESPACE = IOperateDAO.class.getName().concat(".");

    public int wgclOperate(Operate operate);

    public int updateLocation(Operate operate);
}

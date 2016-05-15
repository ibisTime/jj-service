package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDIndividual;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月18日 下午12:01:24 
 * @history:
 */
public interface IFDIndividualDAO extends IBaseDAO<FDIndividual> {

    String NAMESPACE = IFDIndividualDAO.class.getName().concat(".");

    public int update(FDIndividual data);
}

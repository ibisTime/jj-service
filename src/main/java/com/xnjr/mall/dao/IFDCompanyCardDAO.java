package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDCompanyCard;

/**
 * 
 * @author: Gejin 
 * @since: 2016年4月18日 上午11:40:34 
 * @history:
 */
public interface IFDCompanyCardDAO extends IBaseDAO<FDCompanyCard> {

    String NAMESPACE = IFDCompanyCardDAO.class.getName().concat(".");

    public int update(FDCompanyCard data);
}

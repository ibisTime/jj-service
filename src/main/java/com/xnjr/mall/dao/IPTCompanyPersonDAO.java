package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.PTCompanyPerson;

/**
 * 公司人员DAO
 * @author: xieyj 
 * @since: 2016年1月17日 上午10:44:37 
 * @history:
 */
public interface IPTCompanyPersonDAO extends IBaseDAO<PTCompanyPerson> {
    String NAMESPACE = IPTCompanyPersonDAO.class.getName().concat(".");

    public int deletePTCompanyPersonByCompany(PTCompanyPerson condition);

    public int update(PTCompanyPerson condition);

}

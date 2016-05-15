package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDCompany;

/** 
 * 公司列表DAO
 * @author: wuql
 * @since: 2016年1月14日 下午2:26:01 
 * @history:
 */
public interface IFDCompanyDAO extends IBaseDAO<FDCompany> {
    String NAMESPACE = IFDCompanyDAO.class.getName().concat(".");

    public int updatePicture(FDCompany data);

    public int updateCompany(FDCompany data);

    public int doKYC(FDCompany data);
}

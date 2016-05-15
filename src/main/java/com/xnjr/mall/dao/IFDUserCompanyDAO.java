package com.xnjr.mall.dao;

import java.util.List;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserCompany;

public interface IFDUserCompanyDAO extends IBaseDAO<FDUserCompany> {
    String NAMESPACE = IFDUserCompanyDAO.class.getName().concat(".");

    List<FDCompany> selectCompanyList(FDUserCompany condition);

    Long selectCompanyTotalCount(FDUserCompany condition);

    List<FDCompany> selectCompanyList(int start, int count,
            FDUserCompany condition);

    List<FDUser> selectUserList(FDUserCompany condition);

    int updateUserCompany(FDUserCompany data);

    int updateKYCUserCompany(FDUserCompany data);
}

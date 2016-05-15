package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.SYSUser;

public interface ISYSUserDAO extends IBaseDAO<SYSUser> {
    String NAMESPACE = ISYSUserDAO.class.getName().concat(".");

    public int updateSYSUser(SYSUser data);

    public int updateSYSUserRealInfo(SYSUser data);

    public int updateSYSUserLoginPwd(SYSUser data);

    public int updateSYSUserTradePwd(SYSUser data);

    public int updateSYSUserContact(SYSUser data);

    public int updateSYSUserRoleCode(SYSUser data);

}

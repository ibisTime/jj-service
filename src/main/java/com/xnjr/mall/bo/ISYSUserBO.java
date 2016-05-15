package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.SYSUser;

public interface ISYSUserBO extends IPaginableBO<SYSUser> {
    public void checkSYSUserExist(String loginName);

    public boolean isSYSUserExist(String userId);

    public String saveSYSUser(SYSUser data);

    public int removeSYSUser(SYSUser data);

    public int refreshSYSUser(SYSUser data);

    public int refreshSYSUserIds(SYSUser data);

    public int refreshSYSUserLoginPwd(SYSUser data);

    public int refreshSYSUserTradePwd(SYSUser data);

    public int refreshSYSUserContact(SYSUser data);

    public int refreshSYSUserRoleCode(SYSUser data);

    public SYSUser getSYSUser(String userId);

    public List<SYSUser> querySYSUserList(SYSUser data);

    public void checkTradePwd(String userId, String tradePwd);
}

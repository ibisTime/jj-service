/**
 * @Title ISYSUserAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年4月17日 上午11:02:53 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SYSUser;

/** 
 * @author: xieyj 
 * @since: 2016年4月17日 上午11:02:53 
 * @history:
 */
public interface ISYSUserAO {

    String DEFAULT_ORDER_COLUMN = "user_id";

    public String addSYSUser(SYSUser data);

    public int dropSYSUser(SYSUser data);

    public int editSYSUser(SYSUser data);

    public int doVerifySYSUserIds(SYSUser data);

    public int doEditSYSUserPwd(SYSUser data);

    public int doResetSYSUserPwdByAdmin(String adminId, String adminTradePwd,
            String userId);

    public int doEditSYSUserTradePwd(SYSUser data);

    public int doResetSYSUserTradePwdByAdmin(String adminId,
            String adminTradePwd, String userId);

    public int doEditSYSUserContact(SYSUser data);

    public int doAssignSYSUserRole(SYSUser data);

    public String doLoginSYSUser(SYSUser data);

    public Paginable<SYSUser> querySYSUserPage(int start, int limit,
            SYSUser condition);

    public List<SYSUser> querySYSUserList(SYSUser condition);

    public SYSUser getSYSUserDetail(String code);
}

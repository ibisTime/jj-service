/**
 * @Title IUserBO.java 
 * @Package com.ibis.pz 
 * @Description 
 * @author miyb  
 * @date 2015-3-7 上午9:17:37 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDUser;

/** 
 * @author: miyb 
 * @since: 2015-3-7 上午9:17:37 
 * @history:
 */
public interface IFDUserBO extends IPaginableBO<FDUser> {
    /**
     * 验证交易密码:拿tradePwd进行MD5后与数据库中userId得数据库交易密码比对
     * @param userId
     * @param tradePwd 
     * @create: 2015年11月1日 下午4:47:48 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

    /**
     * 验证登录密码:拿loginPwd进行MD5后与数据库中userId得数据库交易密码比对
     * @param userId
     * @param loginPwd 
     * @create: 2015年11月2日 下午1:18:57 myb858
     * @history:
     */
    public void checkLoginPwd(String userId, String loginPwd);

    /**
     *  判断手机号是否存在
     * @param mobile
     * @return 
     * @create: 2015-5-16 下午4:08:06 miyb
     * @history:
     */
    public void isMobileExist(String mobile);

    /**
     *  判断推荐人是否存在(手机号)
     * @param userReferee 推荐人
     * @return 
     * @create: 2015-5-16 下午4:08:06 miyb
     * @history:
     */
    public void checkUserReferee(String userReferee);

    /** 
     * 注册
     * @param mobile
     * @param loginPwd
     * @param registerIp
     * @param userReferee
     * @return 
     * @create: 2015-5-16 下午5:35:36 miyb
     * @history: 
     */
    public String doRegister(String mobile, String loginPwd, String registerIp,
            String userReferee);

    public int removeUser(String userId);

    public int refreshIdentity(String userId, String realName, String idKind,
            String idNo);

    public int refreshLoginPwd(String userId, String loginPwd,
            String loginPwdStrength);

    public int refreshTradePwd(String userId, String tradePwd,
            String tradePwdStrength);

    public int refreshMobile(String userId, String mobile);

    public String doAddUser(String mobile, String loginPsd, String userReferee,
            String realName, String idKind, String idNo, String tradePsd);

    public FDUser getUser(String userId);

    public FDUser getUserByMobile(String mobile);

    public List<FDUser> queryUserList(FDUser data);

    public int doKYC(FDUser admin, String serveList, String quoteList,
            Integer level);

    public int doKYCIndividual(FDUser admin, String serveList,
            String quoteList, Integer level);
}

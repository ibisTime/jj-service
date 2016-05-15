/**
 * @Title IFDUserAO.java 
 * @Package com.ibis.pz.user 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:48:42 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUser;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:48:42 
 * @history:
 */
public interface IFDUserAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    /** 
     * 根据手机号获取用户信息
     * @param mobile
     * @return 
     * @create: 2015-5-24 下午4:37:01 miyb
     * @history: 
     */
    public FDUser doGetUserByMobile(String mobile);

    /**
     * 检查手机号是否存在
     * @param mobile 
     * @create: 2016年1月21日 下午1:36:39 myb858
     * @history:
     */
    public void doCheckMobile(String mobile);

    /**
     * 注册
     * @param mobile
     * @param smsCaptcha
     * @param loginPwd
     * @param registerIp
     * @param userReferee
     * @return 
     * @create: 2016年1月13日 下午8:55:32 myb858
     * @history:
     */
    public String doRegister(String mobile, String smsCaptcha, String loginPwd,
            String registerIp, String userReferee);

    /**
     * 用户登陆
     * @param loginName
     * @param loginPwd
     * @param loginIp
     * @return 
     * @create: 2015年10月15日 下午2:45:52 myb858
     * @history:
     */

    public String doLogin(String loginName, String loginPwd, String loginIp);

    /**
     * 查询用户的详细信息
     * @param userId
     * @create: 2014-12-10 下午7:37:18 miyb
     * @history:
     */
    public FDUser doGetUser(String userId);

    /**
     * 三方实名认证
     * @param userId
     * @param idKind
     * @param idNo
     * @param realName
     * @return 
     * @create: 2016年1月13日 下午9:00:53 myb858
     * @history:
     */
    public void doIdentify(String userId, String idKind, String idNo,
            String realName);

    /**
     * 设置交易密码
     * @param userId
     * @param tradePwd
     * @param smsCaptcha
     * @return 
     * @create: 2015年9月19日 上午11:03:29 myb858
     * @history:
     */
    public void doSetTradePwd(String userId, String tradePwd,
            String tradePwdStrength, String smsCaptcha);

    /**
     * 找回登录密码
     * @param mobile
     * @param newLoginPwd
     * @param smsCaptcha
     * @return 
     * @create: 2015年9月15日 下午8:51:01 myb858
     * @history:
     */
    public boolean doFindLoginPwd(String mobile, String newLoginPwd,
            String newLoginPwdStrength, String smsCaptcha);

    /** 
     * 重置登录密码
     * @param userId
     * @param oldLoginPwd
     * @param newLoginPwd
     * @return 
     * @create: 2015-5-17 上午10:35:14 miyb
     * @history: 
     */
    public boolean doResetLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd, String newLoginPwdStrength);

    /**
     * 找回交易密码
     * @param userId
     * @param newTradePwd
     * @param smsCaptcha
     * @param idKind
     * @param idNo
     * @return 
     * @create: 2015年9月16日 下午3:38:33 myb858
     * @history:
     */
    public boolean doFindTradePwd(String userId, String newTradePwd,
            String newTradePwdStrength, String smsCaptcha, String idKind,
            String idNo);

    /** 
     * 重置交易密码
     * @param userId
     * @param oldTradePwd
     * @param newTradePwd
     * @return 
     * @create: 2015-5-17 上午11:00:13 miyb
     * @history: 
     */
    public boolean doResetTradePwd(String userId, String oldTradePwd,
            String newTradePwd, String newTradePwdStrength);

    /**
     * 更换手机号
     * @param userId
     * @param newMobile
     * @param smsCaptcha
     * @param tradePwd
     * @return 
     * @create: 2015年9月17日 下午12:42:33 myb858
     * @history:
     */
    public boolean doChangeMoblie(String userId, String newMobile,
            String smsCaptcha, String tradePwd);

    /** 
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015-6-7 上午10:04:12 miyb
     * @history: 
     */
    public Paginable<FDUser> queryUserPage(int start, int limit,
            FDUser condition);

    /**
     * 
     * @param condition
     * @return 
     * @create: 2015年10月28日 下午2:41:48 myb858
     * @history:
     */
    public List<FDUser> queryUserList(FDUser condition);

    /**
     * 校验交易密码
     * @param userId
     * @param tradePwd
     * @return 
     * @create: 2015年11月10日 上午9:16:42 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

    /**
     * kyc 个体户
     * @param userId
     * @param individualCode 
     * @create: 2016年4月23日 上午10:33:49 xieyj
     * @history:
     */
    public void doKYCIndividual(String userId, String individualCode);

    public void doIdentifySetTradePwd(String userId, String idKind,
            String idNo, String realName, String tradePwd,
            String newTradePwdStrength, String smsCaptcha);

    /**
     * 获取"我"所拥有的银行账号列表
     * @param userId
     * @return 
     * @create: 2016年4月28日 上午11:26:03 xieyj
     * @history:
     */
    public List<Object> queryMyBankCardNoList(String userId);

    /**
     * kyc 个体户
     * @param userId
     * @param individualCode 
     * @create: 2016年4月23日 上午10:33:49 xieyj
     * @history:
     */
    public void doKYCIndividual(String userId);

}

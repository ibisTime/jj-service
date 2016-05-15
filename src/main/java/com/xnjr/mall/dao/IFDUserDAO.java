/**
 * @Title IUserDAO.java 
 * @Package com.ibis.pz 
 * @Description 
 * @author miyb  
 * @date 2015-2-6 上午10:22:02 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.FDUser;

/** 
 * @author: miyb 
 * @since: 2015-2-6 上午10:22:02 
 * @history:
 */
public interface IFDUserDAO extends IBaseDAO<FDUser> {
    String NAMESPACE = IFDUserDAO.class.getName().concat(".");

    /** 
     * 实名认证
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateIdentity(FDUser data);

    /** 
     * 设置交易密码
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateTradePwd(FDUser data);

    /** 
     * 设置登陆密码
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateLoginPwd(FDUser data);

    /** 
     * 更新手机号
     * @param data
     * @return 
     * @create: 2015-2-23 下午4:28:41 miyb
     * @history: 
     */
    public int updateMobile(FDUser data);

    /**
     * 其他系统代注册
     * @param data
     * @return 
     * @create: 2016年4月20日 下午4:23:37 xieyj
     * @history:
     */
    public int quickInsertFDUser(FDUser data);

    /**
     * KYC
     * @param data
     * @return 
     * @create: 2016年1月16日 下午2:01:38 myb858
     * @history:
     */
    public int doKYC(FDUser data);

    /**
     * 更新个体户kyc
     * @param data
     * @return 
     * @create: 2016年4月23日 上午10:23:36 xieyj
     * @history:
     */
    public int doKYCIndividual(FDUser data);

}

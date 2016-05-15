/**
 * @Title SYSUserAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月17日 下午1:37:43 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ISYSUserAO;
import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserIdentifyBO;
import com.xnjr.mall.bo.IFDUserLoginLogBO;
import com.xnjr.mall.bo.IIdentifyBO;
import com.xnjr.mall.bo.ISYSConfigBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.MD5Util;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.common.PropertiesUtil;
import com.xnjr.mall.common.PwdUtil;
import com.xnjr.mall.core.RandomGenerater;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.enums.ECurrency;
import com.xnjr.mall.enums.EIDKind;
import com.xnjr.mall.enums.EKind;
import com.xnjr.mall.enums.ELoginStatus;
import com.xnjr.mall.enums.ESYSUserStatus;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年4月17日 下午1:37:43 
 * @history:
 */
@Service
public class SYSUserAOImpl implements ISYSUserAO {
    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    @Autowired
    IFDUserBO fdUserBO;

    @Autowired
    IFDUserLoginLogBO fdUserLoginLogBO;

    @Autowired
    IIdentifyBO identifyBO;

    @Autowired
    IFDUserIdentifyBO fdUserIdentifyBO;

    @Autowired
    IFDAccountBO fdAccountBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Override
    @Transactional
    public String addSYSUser(SYSUser data) {
        SYSUser condition = new SYSUser();
        condition.setLoginName(data.getLoginName());
        List<SYSUser> sysUserList = sysUserBO.querySYSUserList(condition);
        if (CollectionUtils.isNotEmpty(sysUserList)) {
            for (SYSUser sysUser : sysUserList) {
                if (sysUser.getLoginName().equals(data.getLoginName())) {
                    throw new BizException("lh0000", "用户名已存在！");
                }
            }
        }
        // 判断是否资金方,是则代理注册
        if (EKind.FUND.getCode().equals(data.getKind())) {
            doAddFdUser(data.getLoginName(), EKind.SYSTEM.getValue(),
                data.getIdKind(), data.getIdNo(), data.getRealName());
        }
        // 初始化登录密码和交易密码
        data.setLoginPwd(MD5Util.md5(sysConfigBO
            .getConfigValue(PropertiesUtil.Config.SYS_INIT_LOGIN_PWD)));
        data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(sysConfigBO
            .getConfigValue(PropertiesUtil.Config.SYS_INIT_LOGIN_PWD)));
        data.setTradePwd(MD5Util.md5(sysConfigBO
            .getConfigValue(PropertiesUtil.Config.SYS_INIT_TRADE_PWD)));
        data.setTradePwdStrength(PwdUtil
            .calculateSecurityLevel(PropertiesUtil.Config.SYS_INIT_TRADE_PWD));
        return sysUserBO.saveSYSUser(data);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#dropSYSUser(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int dropSYSUser(SYSUser data) {
        if (!sysUserBO.isSYSUserExist(data.getUserId())) {
            throw new BizException("lh0000", "删除用户不存在！");
        }
        return sysUserBO.removeSYSUser(data);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#editSYSUser(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int editSYSUser(SYSUser data) {
        if (!sysUserBO.isSYSUserExist(data.getUserId())) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        SYSUser condition = new SYSUser();
        condition.setLoginName(data.getLoginName());
        List<SYSUser> sysUserList = sysUserBO.querySYSUserList(condition);
        if (CollectionUtils.isNotEmpty(sysUserList)) {
            for (SYSUser sysUser : sysUserList) {
                if (!sysUser.getUserId().equals(data.getUserId())
                        && sysUser.getLoginName().equals(data.getLoginName())) {
                    throw new BizException("lh0000", "用户名已存在！");
                }
            }
        }
        return sysUserBO.refreshSYSUser(data);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#doVerifySYSUserIds(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int doVerifySYSUserIds(SYSUser data) {
        if (!sysUserBO.isSYSUserExist(data.getUserId())) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        return sysUserBO.refreshSYSUserIds(data);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#doEditSYSUserPwd(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int doEditSYSUserPwd(SYSUser data) {
        SYSUser sysUser = sysUserBO.getSYSUser(data.getUserId());
        if (sysUser == null) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        if (!data.getOldLoginPwd().equals(sysUser.getLoginPwd())) {
            throw new BizException("lh0000", "原密码不正确！");
        }
        if (data.getOldLoginPwd().equals(data.getLoginPwd())) {
            throw new BizException("lh0000", "原密码和新密码一致！");
        }
        return sysUserBO.refreshSYSUserLoginPwd(data);

    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#doResetSYSUserPwdByAdmin(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int doResetSYSUserPwdByAdmin(String adminId, String adminTradePwd,
            String userId) {
        SYSUser sysUser = sysUserBO.getSYSUser(adminId);
        if (sysUser != null) {
            if (!adminTradePwd.equals(sysUser.getTradePwd())) {
                throw new BizException("lh0000", "管理员交易密码错误！");
            }
        }
        if (!sysUserBO.isSYSUserExist(userId)) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        SYSUser data = new SYSUser();
        data.setUserId(userId);
        data.setLoginPwd(MD5Util.md5(sysConfigBO
            .getConfigValue(PropertiesUtil.Config.SYS_INIT_LOGIN_PWD)));
        data.setLoginPwdStrength(PwdUtil.calculateSecurityLevel(sysConfigBO
            .getConfigValue(PropertiesUtil.Config.SYS_INIT_LOGIN_PWD)));
        data.setRemark("管理员重置登录密码");
        return sysUserBO.refreshSYSUserLoginPwd(data);
    }

    @Override
    public int doEditSYSUserTradePwd(SYSUser data) {
        SYSUser sysUser = sysUserBO.getSYSUser(data.getUserId());
        if (sysUser == null) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        if (!data.getOldTradePwd().equals(sysUser.getTradePwd())) {
            throw new BizException("lh0000", "原交易密码不正确！");
        }
        if (data.getOldTradePwd().equals(data.getTradePwd())) {
            throw new BizException("lh0000", "原交易密码和新交易密码一致！");
        }
        return sysUserBO.refreshSYSUserTradePwd(data);
    }

    @Override
    public int doResetSYSUserTradePwdByAdmin(String adminId,
            String adminTradePwd, String userId) {
        SYSUser sysUser = sysUserBO.getSYSUser(adminId);
        if (sysUser != null) {
            if (!adminTradePwd.equals(sysUser.getTradePwd())) {
                throw new BizException("lh0000", "管理员交易密码错误！");
            }
        }
        if (!sysUserBO.isSYSUserExist(userId)) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        SYSUser data = new SYSUser();
        data.setUserId(userId);
        data.setTradePwd(MD5Util.md5(sysConfigBO
            .getConfigValue(PropertiesUtil.Config.SYS_INIT_TRADE_PWD)));
        data.setTradePwdStrength(PwdUtil
            .calculateSecurityLevel(PropertiesUtil.Config.SYS_INIT_TRADE_PWD));
        data.setRemark("管理员重置交易密码");
        return sysUserBO.refreshSYSUserTradePwd(data);

    }

    @Override
    public int doEditSYSUserContact(SYSUser data) {
        if (!sysUserBO.isSYSUserExist(data.getUserId())) {
            throw new BizException("lh0000", "用户编号不存在！");
        }
        return sysUserBO.refreshSYSUserContact(data);
    }

    @Override
    public int doAssignSYSUserRole(SYSUser data) {
        if (!sysUserBO.isSYSUserExist(data.getUserId())) {
            throw new BizException("lh0000", "用户编号不存在");
        }
        return sysUserBO.refreshSYSUserRoleCode(data);
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#doLoginSYSUser(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public String doLoginSYSUser(SYSUser data) {
        List<SYSUser> sysUserList = sysUserBO.querySYSUserList(data);
        if (CollectionUtils.isEmpty(sysUserList)) {
            throw new BizException("xn702002", "登录名或密码不正确");
        }
        SYSUser sysUser = null;
        for (SYSUser domain : sysUserList) {
            if (domain.getLoginName().equals(data.getLoginName())
                    && domain.getLoginPwd().equals(data.getLoginPwd())) {
                sysUser = domain;
                break;
            }
        }
        if (sysUser == null) {
            throw new BizException("xn702002", "登录名或密码不正确");
        }
        if (ESYSUserStatus.BLOCK.getCode().equals(sysUser.getStatus())) {
            throw new BizException("xn702002", "该用户已被注销");
        }
        // 待记录登录日志
        return sysUser.getUserId();
    }

    /** 
     * @see com.xnjr.mall.ao.ISYSUserAO#doAddFdUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String doAddFdUser(String mobile, String userReferee, String idKind,
            String idNo, String realName) {
        // 验证手机号
        fdUserBO.isMobileExist(mobile);
        // 插入用户信息
        String loginPsd = RandomGenerater.generate6();
        String tradePsd = RandomGenerater.generate6();
        String userId = fdUserBO.doAddUser(mobile, loginPsd, userReferee,
            realName, idKind, idNo, tradePsd);
        // 记录注册日志
        fdUserLoginLogBO.saveUserLoginLog(userId, "255.255.255.0",
            ELoginStatus.REGISTERSUCCESS.getCode());
        // 三方认证
        identifyBO.doIdentify(userId, realName, idKind, idNo);
        // 保存用户认证记录
        fdUserIdentifyBO.saveUserIdentify(userId, realName,
            EIDKind.IDCard.getCode(), idNo, "0", "success");

        // 分配账号
        fdAccountBO
            .distributeAccount(userId, realName, ECurrency.CNY.getCode());

        // 发送短信
        smsOutBO
            .sendSmsOut(
                mobile,
                "尊敬的"
                        + PhoneUtil.hideMobile(mobile)
                        + "用户，您已成功注册生意家。您的登录密码为"
                        + loginPsd
                        + ";交易密码为"
                        + tradePsd
                        + "，请及时登录生意家网站修改密码。如有疑问，请联系客服："
                        + sysConfigBO
                            .getConfigValue(PropertiesUtil.Config.CUSTOMER_TELEPHONE)
                        + "。", ESmsBizType.FUND_ADD.getCode(),
                ESmsBizType.FUND_ADD.getValue());
        return userId;
    }

    @Override
    public Paginable<SYSUser> querySYSUserPage(int start, int limit,
            SYSUser condition) {
        return sysUserBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<SYSUser> querySYSUserList(SYSUser condition) {
        return sysUserBO.querySYSUserList(condition);
    }

    @Override
    public SYSUser getSYSUserDetail(String userId) {
        return sysUserBO.getSYSUser(userId);
    }
}

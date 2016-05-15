/**
 * @Title FDUserAOImpl.java 
 * @Package com.ibis.pz.user.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:52:06 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.bo.IFDAccountBO;
import com.xnjr.mall.bo.IFDBankCardBO;
import com.xnjr.mall.bo.IFDCompanyCardBO;
import com.xnjr.mall.bo.IFDIndividualBO;
import com.xnjr.mall.bo.IFDUserAccountBO;
import com.xnjr.mall.bo.IFDUserBO;
import com.xnjr.mall.bo.IFDUserCompanyBO;
import com.xnjr.mall.bo.IFDUserIdentifyBO;
import com.xnjr.mall.bo.IFDUserLoginLogBO;
import com.xnjr.mall.bo.IIdentifyBO;
import com.xnjr.mall.bo.ISYSConfigBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.MD5Util;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.common.PropertiesUtil;
import com.xnjr.mall.domain.FDBankCard;
import com.xnjr.mall.domain.FDCompany;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.domain.FDIndividual;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.domain.FDUserCompany;
import com.xnjr.mall.enums.ECurrency;
import com.xnjr.mall.enums.EIDKind;
import com.xnjr.mall.enums.EKYCStatus;
import com.xnjr.mall.enums.ELoginStatus;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:52:06 
 * @history:
 */
@Service
public class FDUserAOImpl implements IFDUserAO {
    @Autowired
    protected IFDUserBO fdUserBO;

    @Autowired
    protected IFDAccountBO fdAccountBO;

    @Autowired
    protected IFDBankCardBO fdBankCardBO;

    @Autowired
    protected IFDUserLoginLogBO fdUserLoginLogBO;

    @Autowired
    IIdentifyBO identifyBO;

    @Autowired
    IFDUserIdentifyBO fdUserIdentifyBO;

    @Autowired
    IFDIndividualBO fdIndividualBO;

    @Autowired
    protected IFDUserAccountBO fdUserAccountBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    IFDUserCompanyBO fdUserCompanyBO;

    @Autowired
    IFDCompanyCardBO fdCompanyCardBO;

    @Autowired
    ISYSConfigBO sysConfigBO;

    /** 
     * @see com.ibis.account.ao.IFDUserAO#doGetFDUserByMobile(java.lang.String)
     */
    @Override
    public FDUser doGetUserByMobile(String mobile) {
        return fdUserBO.getUserByMobile(mobile);
    }

    @Override
    @Transactional
    public String doRegister(String mobile, String smsCaptcha, String loginPwd,
            String registerIp, String userReferee) {
        // 验证手机号
        fdUserBO.isMobileExist(mobile);
        // 验证推荐人是否是平台的已注册用户
        fdUserBO.checkUserReferee(userReferee);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha,
            ESmsBizType.REGISTER.getCode());
        // 插入用户信息
        String userId = fdUserBO.doRegister(mobile, loginPwd, registerIp,
            userReferee);
        // 记录注册日志
        fdUserLoginLogBO.saveUserLoginLog(userId, registerIp,
            ELoginStatus.REGISTERSUCCESS.getCode());
        // 分配账号
        fdAccountBO.distributeAccount(userId, null, ECurrency.CNY.getCode());
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，恭喜您成功注册。请妥善保管您的账户相关信息。", ESmsBizType.REGISTER.getCode(),
            ESmsBizType.REGISTER.getValue());
        return userId;
    }

    @Override
    public String doLogin(String loginName, String loginPwd, String loginIp) {
        FDUser condition = new FDUser();
        condition.setMobile(loginName);
        condition.setLoginPwd(MD5Util.md5(loginPwd));
        List<FDUser> userList = fdUserBO.queryUserList(condition);
        if (CollectionUtils.isEmpty(userList)) {
            // 记录错误日志
            fdUserLoginLogBO.saveUserLoginLog(loginName, loginIp,
                ELoginStatus.FAILURE.getCode());
            throw new BizException("xn702002", "登录名或密码不正确");
        }
        // 记录正确日志
        FDUser user = userList.get(0);
        fdUserLoginLogBO.saveUserLoginLog(user.getUserId(), loginIp,
            ELoginStatus.SUCCESS.getCode());
        return user.getUserId();
    }

    @Override
    public FDUser doGetUser(String userId) {
        FDUser user = fdUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", userId + "用户不存在");
        }
        return user;
    }

    @Override
    @Transactional
    public void doSetTradePwd(String userId, String tradePwd,
            String tradePwdStrength, String smsCaptcha) {
        // 判断是否和登录密码重复
        FDUser user = this.doGetUser(userId);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha,
            ESmsBizType.SETTRADEPWD.getCode());
        fdUserBO.refreshTradePwd(userId, tradePwd, tradePwdStrength);
        // 发送短信
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的交易密码设置成功。请妥善保管您的账户相关信息。",
            ESmsBizType.SETTRADEPWD.getCode(),
            ESmsBizType.SETTRADEPWD.getValue());
    }

    @Override
    @Transactional
    public boolean doFindLoginPwd(String mobile, String newLoginPwd,
            String newLoginPwdStrength, String smsCaptcha) {
        FDUser user = fdUserBO.getUserByMobile(mobile);
        if (user == null) {// 这里其实还有一种处理方法：就是直接注册
            throw new BizException("li01004", "用户不存在,请先注册");
        }
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(mobile, smsCaptcha,
            ESmsBizType.FINDLOGINPWD.getCode());

        fdUserBO.refreshLoginPwd(user.getUserId(), MD5Util.md5(newLoginPwd),
            newLoginPwdStrength);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的登录密码找回成功。请妥善保管您的账户相关信息。",
            ESmsBizType.FINDLOGINPWD.getCode(),
            ESmsBizType.FINDLOGINPWD.getValue());
        return true;
    }

    /** 
     * @see com.ibis.pz.user.IFDUserAO#doResetLoginPwd(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public boolean doResetLoginPwd(String userId, String oldLoginPwd,
            String newLoginPwd, String newLoginPwdStrength) {
        if (oldLoginPwd.equals(newLoginPwd)) {
            throw new BizException("li01006", "新登录密码不能与原有密码重复");
        }
        // 验证当前登录密码是否正确
        fdUserBO.checkLoginPwd(userId, oldLoginPwd);
        // 重置
        fdUserBO.refreshLoginPwd(userId, MD5Util.md5(newLoginPwd),
            newLoginPwdStrength);

        // 发送短信
        FDUser user = fdUserBO.getUser(userId);
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的登录密码修改成功。请妥善保管您的账户相关信息。",
            ESmsBizType.RESETLOGINPWD.getCode(),
            ESmsBizType.RESETLOGINPWD.getValue());
        return true;
    }

    @Override
    @Transactional
    public boolean doFindTradePwd(String userId, String newTradePwd,
            String newTradePwdStrength, String smsCaptcha, String idKind,
            String idNo) {
        FDUser user = fdUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户名不存在");
        }
        if (user.getIdKind() == null || user.getIdNo() == null) {
            throw new BizException("li01004", "请先实名认证");
        }
        // 证件是否正确
        if (!(user.getIdKind().equalsIgnoreCase(idKind) && user.getIdNo()
            .equalsIgnoreCase(idNo))) {
            throw new BizException("li01009", "证件验证不通过");
        }

        // 短信验证码是否正确
        String mobile = user.getMobile();
        smsOutBO.checkCaptcha(mobile, smsCaptcha,
            ESmsBizType.FINDTRADEPWD.getCode());
        fdUserBO.refreshTradePwd(userId, newTradePwd, newTradePwdStrength);
        // 发送短信
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的交易密码找回成功。请妥善保管您的账户相关信息。",
            ESmsBizType.FINDTRADEPWD.getCode(),
            ESmsBizType.FINDTRADEPWD.getValue());
        return true;
    }

    /** 
     * @see com.ibis.pz.user.IFDUserAO#doResetTradePwd(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public boolean doResetTradePwd(String userId, String oldTradePwd,
            String newTradePwd, String newTradePwdStrength) {
        if (oldTradePwd.equals(newTradePwd)) {
            throw new BizException("li01008", "新交易密码与原有交易密码重复");
        }
        FDUser user = null;
        FDUser conditon = new FDUser();
        conditon.setUserId(userId);
        conditon.setTradePwd(MD5Util.md5(oldTradePwd));
        List<FDUser> list = fdUserBO.queryUserList(conditon);
        if (CollectionUtils.isNotEmpty(list)) {
            user = list.get(0);
        } else {
            throw new BizException("li01008", "旧交易密码不正确");
        }
        fdUserBO.refreshTradePwd(userId, newTradePwd, newTradePwdStrength);
        // 发送短信
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的交易密码修改成功。请妥善保管您的账户相关信息。",
            ESmsBizType.RESETTRADEPWD.getCode(),
            ESmsBizType.RESETTRADEPWD.getValue());
        return true;
    }

    @Override
    @Transactional
    public boolean doChangeMoblie(String userId, String newMobile,
            String smsCaptcha, String tradePwd) {
        FDUser user = fdUserBO.getUser(userId);
        if (user == null) {
            throw new BizException("li01004", "用户名不存在");
        }
        String oldMobile = user.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException("li01009", "新手机与原手机一致");
        }
        fdUserBO.isMobileExist(newMobile);
        // 验证交易密码
        fdUserBO.checkTradePwd(userId, tradePwd);
        // 短信验证码是否正确（往新手机号发送）
        smsOutBO.checkCaptcha(newMobile, smsCaptcha,
            ESmsBizType.CHANGEMOBILE.getCode());
        fdUserBO.refreshMobile(userId, newMobile);
        // 发送短信
        smsOutBO.sendSmsOut(
            oldMobile,
            "尊敬的"
                    + PhoneUtil.hideMobile(oldMobile)
                    + "用户，您于"
                    + DateUtil.dateToStr(new Date(),
                        DateUtil.DATA_TIME_PATTERN_1)
                    + "提交的更改绑定手机号码服务审核通过，您的新绑定手机号码为" + newMobile
                    + "，请妥善保管您的账户相关信息。", ESmsBizType.CHANGEMOBILE.getCode(),
            ESmsBizType.CHANGEMOBILE.getValue());
        return true;
    }

    @Override
    public Paginable<FDUser> queryUserPage(int start, int limit,
            FDUser condition) {
        return fdUserBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<FDUser> queryUserList(FDUser condition) {
        return fdUserBO.queryUserList(condition);
    }

    @Override
    public void doCheckMobile(String mobile) {
        FDUser condition = new FDUser();
        condition.setMobile(mobile);
        List<FDUser> userList = queryUserList(condition);
        if (CollectionUtils.isNotEmpty(userList)) {
            throw new BizException("li01009", "手机号已存在");
        }
    }

    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        fdUserBO.checkTradePwd(userId, tradePwd);
    }

    @Override
    @Transactional
    public void doIdentifySetTradePwd(String userId, String idKind,
            String idNo, String realName, String tradePwd,
            String tradePwdStrength, String smsCaptcha) {
        fdUserIdentifyBO.isChecked(realName, idKind, idNo);
        // 三方认证
        identifyBO.doIdentify(userId, realName, idKind, idNo);
        // 更新用户表
        fdUserBO.refreshIdentity(userId, realName, EIDKind.IDCard.getCode(),
            idNo);
        // 回写Account表realName;
        fdAccountBO.refreshRealName(userId, realName);
        // 保存用户认证记录
        fdUserIdentifyBO.saveUserIdentify(userId, realName,
            EIDKind.IDCard.getCode(), idNo, "0", "success");
        // 开始交易密码设置
        // 判断是否和登录密码重复
        FDUser user = this.doGetUser(userId);
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(user.getMobile(), smsCaptcha,
            ESmsBizType.SETTRADEPWD.getCode());
        fdUserBO.refreshTradePwd(userId, tradePwd, tradePwdStrength);
        // 发送短信
        String mobile = user.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您已通过实名认证，且交易密码设置成功。请妥善保管您的账户相关信息。",
            ESmsBizType.SETTRADEPWD.getCode(),
            ESmsBizType.SETTRADEPWD.getValue());
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserAO#doIdentify(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public void doIdentify(String userId, String idKind, String idNo,
            String realName) {
        fdUserIdentifyBO.isChecked(realName, idKind, idNo);
        // 三方认证
        identifyBO.doIdentify(userId, realName, idKind, idNo);
        // 更新用户表
        fdUserBO.refreshIdentity(userId, realName, EIDKind.IDCard.getCode(),
            idNo);
        // 回写Account表realName;
        fdAccountBO.refreshRealName(userId, realName);
        // 保存用户认证记录
        fdUserIdentifyBO.saveUserIdentify(userId, realName,
            EIDKind.IDCard.getCode(), idNo, "0", "success");
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserAO#doKYCIndividual(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void doKYCIndividual(String userId) {
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户编号不存在");
        }
        String individualCode = sysConfigBO
            .getConfigValue(PropertiesUtil.Config.INDIVIDUAL_CODE);
        if (StringUtils.isBlank(individualCode)) {
            throw new BizException("fd0000", "配置失效,请联系客服");
        }
        FDIndividual fdIndividual = fdIndividualBO
            .getIndividual(individualCode);
        if (fdIndividual == null) {
            throw new BizException("fd0000", "个体户编号不存在");
        }
        fdUser.setIndividualCode(individualCode);

        // 创建个体账户
        FDUserAccount fdUserAccount = fdUserAccountBO
            .getAccountByUserId(userId);
        if (fdUserAccount == null) {
            fdUserAccountBO.distributeAccount(userId, fdUser.getRealName(),
                ECurrency.CNY.getCode());
        }
        // kyc 赋权
        fdUserBO.doKYCIndividual(fdUser, null, null, null);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserAO#doKYCIndividual(java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public void doKYCIndividual(String userId, String individualCode) {
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户编号不存在");
        }
        FDIndividual fdIndividual = fdIndividualBO
            .getIndividual(individualCode);
        if (fdIndividual == null) {
            throw new BizException("fd0000", "个体户编号不存在");
        }
        fdUser.setIndividualCode(individualCode);

        // 创建个体账户
        FDUserAccount fdUserAccount = fdUserAccountBO
            .getAccountByUserId(userId);
        if (fdUserAccount == null) {
            fdUserAccountBO.distributeAccount(userId, fdUser.getRealName(),
                ECurrency.CNY.getCode());
        }
        // kyc 赋权
        fdUserBO.doKYCIndividual(fdUser, null, null, null);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserAO#queryMyBankCardNoList(java.lang.String)
     */
    @Override
    public List<Object> queryMyBankCardNoList(String userId) {
        FDUser fdUser = fdUserBO.getUser(userId);
        if (fdUser == null) {
            throw new BizException("fd0000", "用户编号不存在");
        }
        List<Object> list = new ArrayList<Object>();
        if (StringUtils.isNotBlank(fdUser.getIndividualCode())) {
            FDBankCard condition = new FDBankCard();
            condition.setUserId(userId);
            list.addAll(fdBankCardBO.queryBankCardList(condition));
        }
        FDUserCompany fdUserCompany = new FDUserCompany();
        fdUserCompany.setUserId(userId);
        fdUserCompany.setStatus(EKYCStatus.KYC_YES.getCode());
        List<FDCompany> companyList = fdUserCompanyBO
            .queryCompanyList(fdUserCompany);
        for (FDCompany fdCompany : companyList) {
            FDCompanyCard condition = new FDCompanyCard();
            condition.setCompanyCode(fdCompany.getCode());
            list.addAll(fdCompanyCardBO.queryCompanyCardList(condition));
        }
        return list;
    }
}

package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.bo.IGSTraderBO;
import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.ISmsOutBO;
import com.xnjr.mall.bo.ISubjectBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.enums.EKind;
import com.xnjr.mall.enums.ESmsBizType;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: wuql
 * @since: 2016年1月13日 下午3:33:41 
 * @history:
 */
@Service
public class GSTraderAOImpl implements IGSTraderAO {
    @Autowired
    IGSTraderBO gsTraderBO;

    @Autowired
    ISYSUserBO sysUserBO;

    @Autowired
    ISmsOutBO smsOutBO;

    @Autowired
    ISubjectBO subjectBO;

    @Override
    public Paginable<GSTrader> queryGSTraderPage(int start, int limit,
            GSTrader condition) {
        return gsTraderBO.getPaginable(start, limit, condition);
    }

    @Override
    public List<GSTrader> queryGSTraderList(GSTrader condition) {
        return gsTraderBO.queryGSTraderList(condition);
    }

    @Override
    @Transactional
    public String addGSTrader(GSTrader data) {
        String userId = null;
        if (data != null) {
            SYSUser sysUser = sysUserBO.getSYSUser(data.getUserId());
            if (sysUser == null) {
                throw new BizException("XN000001", "用户编号不存在");
            } else {
                if (!EKind.GS.getCode().equals(sysUser.getKind())) {
                    throw new BizException("XN000001", "该用户不属于中国高盛方");
                }
            }

            // if (!sysUserBO.isSYSUserExist(data.getUserId())) {
            // throw new BizException("XN000001", "用户编号不存在");
            // }
            // 界面做相应控制，系统用户如果已经成为操盘手，新增操盘手界面下拉用户列表应该过滤
            if (gsTraderBO.isGSTraderExist(data.getUserId())) {
                throw new BizException("XN000001", "该用户已经是操盘手");
            }
            gsTraderBO.saveGSTrader(data);
            userId = data.getUserId();
        }
        return userId;
    }

    @Override
    @Transactional
    public boolean editGSTrader(GSTrader data) {
        if (data != null && gsTraderBO.isGSTraderExist(data.getUserId())) {
            gsTraderBO.refreshGSTrader(data);
        } else {
            throw new BizException("XN000001", "操盘手不存在");
        }
        return true;
    }

    @Override
    @Transactional
    public void doChangeMoblie(String userId, String newMobile,
            String smsCaptcha, String tradePwd) {
        GSTrader trader = getGSTrader(userId);
        String oldMobile = trader.getMobile();
        if (newMobile.equals(oldMobile)) {
            throw new BizException("li01009", "新手机与原手机一致");
        }
        gsTraderBO.isMobileExist(newMobile);
        // 验证交易密码
        sysUserBO.checkTradePwd(userId, tradePwd);
        // 短信验证码是否正确（往新手机号发送）
        smsOutBO.checkCaptcha(newMobile, smsCaptcha,
            ESmsBizType.MOOM_CPS_ChangePH.getCode());
        gsTraderBO.refreshMobile(userId, newMobile);
        // 往旧手机发送短信
        smsOutBO.sendSmsOut(oldMobile, "尊敬的" + PhoneUtil.hideMobile(oldMobile)
                + "用户，您的更换手机号修改成功。请妥善保管您的账户相关信息。",
            ESmsBizType.MOOM_CPS_ChangePH);
    }

    @Override
    @Transactional
    public void doResetTradePwd(String userId, String oldTradePwd,
            String newTradePwd, String newTradePwdStrength) {
        GSTrader gsTrader = gsTraderBO.getGSTrader(userId);
        if (oldTradePwd.equals(newTradePwd)) {
            throw new BizException("li01008", "新交易密码与原有交易密码重复");
        }
        SYSUser sysUser = null;
        SYSUser conditon = new SYSUser();
        conditon.setUserId(userId);
        conditon.setTradePwd(oldTradePwd);
        List<SYSUser> list = sysUserBO.querySYSUserList(conditon);
        if (CollectionUtils.isNotEmpty(list)) {
            sysUser = list.get(0);
            sysUser.setTradePwd(newTradePwd);
            sysUser.setTradePwdStrength(newTradePwdStrength);
        } else {
            throw new BizException("li01008", "旧交易密码不正确");
        }
        sysUserBO.refreshSYSUserTradePwd(sysUser);
        // 发送短信
        String mobile = gsTrader.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的交易密码修改成功。请妥善保管您的账户相关信息。", ESmsBizType.MOOM_CPS_ResetTP);

    }

    @Override
    @Transactional
    public boolean doFindTradePwd(String userId, String newTradePwd,
            String newTradePwdStrength, String smsCaptcha, String idKind,
            String idNo) {
        GSTrader trader = getGSTrader(userId);
        // 获取操盘过对应的系统身份信息
        SYSUser sysUser = sysUserBO.getSYSUser(userId);
        if (sysUser == null) {
            throw new BizException("XN000001", "用户编号不存在");
        } else {
            if (!EKind.GS.getCode().equals(sysUser.getKind())) {
                throw new BizException("XN000001", "该用户不属于中国高盛方");
            }
        }
        if (StringUtils.isBlank(sysUser.getIdKind())
                || StringUtils.isBlank(sysUser.getIdNo())) {
            throw new BizException("li01004", "请先实名认证");
        }
        // 证件是否正确
        if (!(sysUser.getIdKind().equalsIgnoreCase(idKind) && sysUser.getIdNo()
            .equalsIgnoreCase(idNo))) {
            throw new BizException("li01009", "证件验证不通过");
        }
        // 短信验证码是否正确
        smsOutBO.checkCaptcha(trader.getMobile(), smsCaptcha,
            ESmsBizType.MOOM_CPS_FindTP.getCode());
        // 更新密码
        sysUser.setTradePwd(newTradePwd);
        sysUser.setTradePwdStrength(newTradePwdStrength);
        sysUserBO.refreshSYSUserTradePwd(sysUser);
        // 发送短信
        String mobile = trader.getMobile();
        smsOutBO.sendSmsOut(mobile, "尊敬的" + PhoneUtil.hideMobile(mobile)
                + "用户，您的交易密码找回成功。请妥善保管您的账户相关信息。", ESmsBizType.MOOM_CPS_FindTP);
        return true;
    }

    @Override
    public GSTrader getGSTrader(String userId) {
        GSTrader gsTrader = gsTraderBO.getGSTrader(userId);
        if (gsTrader == null) {
            throw new BizException("li01004", "操盘手不存在");
        }
        return gsTrader;
    }
}

package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.bo.IAccountBO;
import com.xnjr.mall.bo.IIntegralBO;
import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Integral;
import com.xnjr.mall.dto.res.XN802013Res;
import com.xnjr.mall.dto.res.XN805901Res;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EDirection;
import com.xnjr.mall.enums.EIntegralStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月25日 上午9:37:32 
 * @history:
 */
@Service
public class IntegralAOImpl implements IIntegralAO {

    @Autowired
    private IIntegralBO integralBO;

    @Autowired
    private IUserBO userBO;

    @Autowired
    private IAccountBO accountBO;

    /** 
     * @see com.xnjr.mall.ao.IIntegralAO#addIntegral(com.xnjr.mall.domain.Integral)
     */
    @Override
    public String addIntegral(Integral data) {
        // 判断用户是否存在
        XN805901Res user = userBO.getRemoteUser(data.getUserId(),
            data.getUserId());
        if (user == null) {
            throw new BizException("xn0000", "用户不存在");
        }
        return integralBO.saveIntegral(data);
    }

    /** 
     * @see com.xnjr.mall.ao.IIntegralAO#queryIntegralPage(int, int, com.xnjr.mall.domain.Integral)
     */
    @Override
    public Paginable<Integral> queryIntegralPage(int start, int limit,
            Integral condition) {
        return integralBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IIntegralAO#queryIntegralList(com.xnjr.mall.domain.Integral)
     */
    @Override
    public List<Integral> queryIntegralList(Integral condition) {
        return integralBO.queryIntegralList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IIntegralAO#getIntegral(java.lang.String)
     */
    @Override
    public Integral getIntegral(String code) {
        integralBO.isExistIntegral(code);
        return integralBO.getIntegral(code);
    }

    /** 
     * @see com.xnjr.mall.ao.IIntegralAO#scannIntegral(java.lang.String, java.lang.String)
     */
    @Override
    public void scannIntegral(String code, String userId) {
        // 判断用户是否存在
        XN805901Res user = userBO.getRemoteUser(userId, userId);
        if (user == null) {
            throw new BizException("xn0000", "用户不存在");
        }
        // 判断所属积分商
        Integral integral = this.getIntegral(code);
        if (!integral.getUserId().equals(user.getUserReferee())) {
            throw new BizException("xn0000", "当前用户所属积分商和积分二维码上商户不符");
        }
        if (EIntegralStatus.INVALID.getCode().equals(integral.getStatus())) {
            throw new BizException("xn0000", "该积分二维码已失效");
        }
        XN802013Res jfAccount = accountBO.getXNBAccountByUserId(integral
            .getUserId());
        if (jfAccount == null) {
            throw new BizException("xn0000", "积分商账户不存在");
        }
        XN802013Res userAccount = accountBO.getXNBAccountByUserId(userId);
        if (userAccount == null) {
            throw new BizException("xn0000", "用户积分账户不存在");
        }
        // 增加记录，只能一次扫描
        if (EBoolean.NO.getCode().equals(integral.getIsApprove())) {
            // 无需审批送积分
            if (jfAccount.getAmount() < integral.getQuantity()) {
                throw new BizException("xn0000", "积分商账户余额不足");
            }
            accountBO.doTransferOss(jfAccount.getAccountNumber(),
                EDirection.MINUS.getCode(), integral.getQuantity(), 0L, "送积分");
            accountBO.doTransferOss(userAccount.getAccountNumber(),
                EDirection.PLUS.getCode(), integral.getQuantity(), 0L, "扫描送积分");
        } else {
            // 需审批送积分
            accountBO.doChargeOffline(userAccount.getAccountNumber(),
                jfAccount.getAccountNumber(), integral.getQuantity(), null);
        }
    }
}

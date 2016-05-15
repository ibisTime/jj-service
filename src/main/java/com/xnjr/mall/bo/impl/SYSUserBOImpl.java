package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ISYSUserBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.ISYSUserDAO;
import com.xnjr.mall.domain.SYSUser;
import com.xnjr.mall.enums.ESYSUserStatus;
import com.xnjr.mall.exception.BizException;

@Component
public class SYSUserBOImpl extends PaginableBOImpl<SYSUser> implements
        ISYSUserBO {

    @Autowired
    private ISYSUserDAO sysUserDAO;

    @Override
    public void checkSYSUserExist(String loginName) {
        SYSUser condition = new SYSUser();
        condition.setLoginName(loginName);
        if (sysUserDAO.selectTotalCount(condition) >= 1) {
            throw new BizException("lh0000", "用户名已存在！");
        }
    }

    @Override
    public boolean isSYSUserExist(String userId) {
        SYSUser condition = new SYSUser();
        condition.setUserId(userId);
        if (sysUserDAO.selectTotalCount(condition) >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public String saveSYSUser(SYSUser data) {
        String userId = null;
        if (data != null) {
            userId = OrderNoGenerater.generateM("SU");
            data.setUserId(userId);
            data.setStatus(ESYSUserStatus.NORMAL.getCode());
            data.setUpdateDatetime(new Date());
            sysUserDAO.insert(data);
        }
        return userId;
    }

    @Override
    public int removeSYSUser(SYSUser data) {
        int count = 0;
        if (data != null) {
            data.setStatus(ESYSUserStatus.BLOCK.getCode());
            count = sysUserDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshSYSUser(SYSUser data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            data.setUpdateDatetime(new Date());
            count = sysUserDAO.updateSYSUser(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSUserBO#refreshSYSUserIds(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int refreshSYSUserIds(SYSUser data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            data.setUpdateDatetime(new Date());
            count = sysUserDAO.updateSYSUserRealInfo(data);
        }
        return count;
    }

    @Override
    public int refreshSYSUserLoginPwd(SYSUser data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            data.setUpdateDatetime(new Date());
            count = sysUserDAO.updateSYSUserLoginPwd(data);
        }
        return count;
    }

    @Override
    public int refreshSYSUserTradePwd(SYSUser data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            data.setUpdateDatetime(new Date());
            count = sysUserDAO.updateSYSUserTradePwd(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSUserBO#refreshSYSUserContact(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int refreshSYSUserContact(SYSUser data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            data.setUpdateDatetime(new Date());
            count = sysUserDAO.updateSYSUserContact(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSUserBO#refreshSYSUserRoleCode(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public int refreshSYSUserRoleCode(SYSUser data) {
        int count = 0;
        if (data != null && StringUtils.isNotBlank(data.getUserId())) {
            data.setUpdateDatetime(new Date());
            count = sysUserDAO.updateSYSUserRoleCode(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSUserBO#getSYSUser(java.lang.String)
     */
    @Override
    public SYSUser getSYSUser(String userId) {
        SYSUser sysUser = null;
        if (StringUtils.isNotBlank(userId)) {
            SYSUser condition = new SYSUser();
            condition.setUserId(userId);
            sysUser = sysUserDAO.select(condition);
        }
        return sysUser;
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSUserBO#querySYSUserList(com.xnjr.mall.domain.SYSUser)
     */
    @Override
    public List<SYSUser> querySYSUserList(SYSUser data) {
        return sysUserDAO.selectList(data);
    }

    /** 
     * @see com.xnjr.mall.bo.ISYSUserBO#checkTradePwd(java.lang.String, java.lang.String)
     */
    @Override
    public void checkTradePwd(String userId, String tradePwd) {
        if (StringUtils.isNotBlank(userId) && StringUtils.isNotBlank(tradePwd)) {
            SYSUser condition = new SYSUser();
            condition.setUserId(userId);
            SYSUser data = sysUserDAO.select(condition);
            if (data == null) {
                throw new BizException("jd00001", "用户编号不存在");
            }
            if (!tradePwd.equals(data.getTradePwd())) {
                throw new BizException("jd00001", "交易密码错误");
            }
        } else {
            throw new BizException("jd00001", "交易密码错误");
        }
    }
}

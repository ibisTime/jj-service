package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDUserLoginLogBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDUserLoginLogDAO;
import com.xnjr.mall.domain.FDUserLoginLog;

/**
 * 用户登录日志
 * @author: xieyj 
 * @since: 2015-3-10 下午8:11:38 
 * @history:
 */
@Component
public class FDUserLoginLogBOImpl extends PaginableBOImpl<FDUserLoginLog>
        implements IFDUserLoginLogBO {

    @Autowired
    private IFDUserLoginLogDAO userLoginLogDAO;

    @Override
    public int saveUserLoginLog(String userId, String loginIp,
            String loginStatus) {
        FDUserLoginLog data = new FDUserLoginLog();
        data.setUserId(userId);
        data.setLoginIp(loginIp);
        data.setLoginDatetime(new Date());
        data.setIsSuccess(loginStatus);
        int count = 0;
        if (data != null) {
            count = userLoginLogDAO.insert(data);
        }
        return count;
    }

    @Override
    public List<FDUserLoginLog> queryUserLoginLogList(FDUserLoginLog data) {
        return userLoginLogDAO.selectList(data);
    }

    @Override
    public FDUserLoginLog getLatestUserLoginLog(String userId) {
        FDUserLoginLog data = null;
        if (StringUtils.isNotBlank(userId)) {
            FDUserLoginLog condition = new FDUserLoginLog();
            condition.setUserId(userId);
            data = userLoginLogDAO.selectLatestUserLoginLog(condition);
        }
        return data;
    }
}

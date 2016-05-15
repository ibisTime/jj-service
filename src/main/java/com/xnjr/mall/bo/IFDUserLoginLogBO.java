package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDUserLoginLog;

/**
 * 用户登录日志
 * @author: xieyj 
 * @since: 2015-3-10 下午8:11:38 
 * @history:
 */
public interface IFDUserLoginLogBO extends IPaginableBO<FDUserLoginLog> {

    public FDUserLoginLog getLatestUserLoginLog(String userId);

    public List<FDUserLoginLog> queryUserLoginLogList(FDUserLoginLog data);

    public int saveUserLoginLog(String userId, String loginIp, String code);

}

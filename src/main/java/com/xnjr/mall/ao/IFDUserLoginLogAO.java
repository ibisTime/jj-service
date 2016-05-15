/**
 * @Title IFDUserLoginLogAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年4月23日 下午1:37:05 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserLoginLog;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * 用户登录日志
 * @author: xieyj 
 * @since: 2016年4月23日 下午1:37:05 
 * @history:
 */
@ServiceModule
public interface IFDUserLoginLogAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    public FDUserLoginLog getLatestUserLoginLog(String userId);

    public Paginable<FDUserLoginLog> queryUserLoginLogPage(int start,
            int limit, FDUserLoginLog condition);

    public List<FDUserLoginLog> queryUserLoginLogList(FDUserLoginLog condition);

}

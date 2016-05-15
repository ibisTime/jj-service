/**
 * @Title IFDUserIdentityAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年4月23日 下午1:37:05 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserIdentify;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * 实名认证
 * @author: xieyj 
 * @since: 2016年4月23日 下午1:37:05 
 * @history:
 */
@ServiceModule
public interface IFDUserIdentifyAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    public Paginable<FDUserIdentify> queryUserIdentifyPage(int start,
            int limit, FDUserIdentify condition);
}

/**
 * @Title IUserIdentifyAO.java 
 * @Package com.ibis.pz.user 
 * @Description 
 * @author miyb  
 * @date 2015-3-8 上午10:48:42 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserIdentify;

/** 
 * @author: miyb 
 * @since: 2015-3-8 上午10:48:42 
 * @history:
 */
public interface IIdentityAO {
    String DEFAULT_ORDER_COLUMN = "user_id";

    /**
     * 三方实名认证
     * @param userId
     * @param idKind
     * @param idNo
     * @param realName
     * @return 
     * @create: 2016年1月13日 下午9:00:53 myb858
     * @history:
     */
    public void doIdentify(String userId, String idKind, String idNo,
            String realName);

    /**
     * 
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年10月28日 下午3:08:37 myb858
     * @history:
     */
    public Paginable<FDUserIdentify> queryUserIdentifyPage(int start,
            int limit, FDUserIdentify condition);
}

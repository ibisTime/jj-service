/**
 * @Title IUserAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年7月26日 下午12:31:53 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.dto.req.XN805042Req;

/** 
 * @author: xieyj 
 * @since: 2016年7月26日 下午12:31:53 
 * @history:
 */
public interface IUserAO {

    public String doAddJfUser(XN805042Req data);

    public String doAddHpUser(XN805042Req data);
}

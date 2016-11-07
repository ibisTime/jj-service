/**
 * @Title IUserBO.java 
 * @Package com.std.forum.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年8月29日 下午8:09:47 
 * @version V1.0   
 */
package com.cdkj.service.bo;

import com.cdkj.service.dto.res.XN805901Res;

/** 
 * @author: xieyj 
 * @since: 2016年8月29日 下午8:09:47 
 * @history:
 */
public interface IUserBO {

    public XN805901Res getRemoteUser(String tokenId, String userId);
}

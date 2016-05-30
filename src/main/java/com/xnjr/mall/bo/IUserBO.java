package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.User;
import com.xnjr.mall.dto.req.XN805056Res;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:13 
 * @history:
 */
public interface IUserBO extends IPaginableBO<User> {
    /**
     * 获取远程用户信息
     * @param userId
     * @return 
     * @create: 2016年5月30日 上午9:27:50 xieyj
     * @history:
     */
    public XN805056Res getRemoteUser(String userId);
}

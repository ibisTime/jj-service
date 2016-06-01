package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.User;
import com.xnjr.mall.dto.res.XN805901Res;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:13 
 * @history:
 */
public interface IUserBO extends IPaginableBO<User> {
    /**
     * 获取远程用户信息
     * @param tokenId
     * @param userId
     * @return 
     * @create: 2016年5月30日 下午3:00:44 xieyj
     * @history:
     */
    public XN805901Res getRemoteUser(String tokenId, String userId);

    /**
     * 校验交易密码
     * @param userId
     * @param tradePwd
     * @return 
     * @create: 2015年11月10日 上午9:16:42 myb858
     * @history:
     */
    public void checkTradePwd(String userId, String tradePwd);

}

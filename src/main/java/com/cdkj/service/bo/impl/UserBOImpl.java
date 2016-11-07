package com.cdkj.service.bo.impl;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.dto.req.XN805901Req;
import com.cdkj.service.dto.res.XN805901Res;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.http.BizConnecter;
import com.cdkj.service.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:30 
 * @history:
 */
@Component
public class UserBOImpl implements IUserBO {

    /** 
     * @see com.xnjr.mall.bo.IUserBO#getRemoteUser(java.lang.String)
     */
    @Override
    public XN805901Res getRemoteUser(String tokenId, String userId) {
        XN805901Req req = new XN805901Req();
        req.setTokenId(tokenId);
        req.setUserId(userId);
        XN805901Res res = BizConnecter.getBizData("805901",
            JsonUtils.object2Json(req), XN805901Res.class);
        if (res == null) {
            throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
        }
        return res;
    }
}

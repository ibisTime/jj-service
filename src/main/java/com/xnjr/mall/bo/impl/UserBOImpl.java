package com.xnjr.mall.bo.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IUserBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.domain.User;
import com.xnjr.mall.dto.req.XN805056Req;
import com.xnjr.mall.dto.req.XN805056Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.http.BizConnecter;
import com.xnjr.mall.http.JsonUtils;

/**
 * @author: xieyj 
 * @since: 2016年5月30日 上午9:28:30 
 * @history:
 */
@Component
public class UserBOImpl extends PaginableBOImpl<User> implements IUserBO {

    /** 
     * @see com.xnjr.mall.bo.IUserBO#getRemoteUser(java.lang.String)
     */
    @Override
    public XN805056Res getRemoteUser(String userId) {
        XN805056Req req = new XN805056Req();
        req.setUserId(userId);
        XN805056Res res = BizConnecter.getBizData("805056",
            JsonUtils.object2Json(req), XN805056Res.class);
        if (res == null
                || (res != null && StringUtils.isBlank(res.getLoginName()))) {
            throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
        }

        return res;
    }
}

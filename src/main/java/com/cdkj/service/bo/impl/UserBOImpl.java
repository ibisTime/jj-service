package com.cdkj.service.bo.impl;

import org.springframework.stereotype.Component;

import com.cdkj.service.bo.IUserBO;
import com.cdkj.service.domain.User;
import com.cdkj.service.dto.req.XN001400Req;
import com.cdkj.service.dto.res.XN001400Res;
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

    @Override
    public User getRemoteUser(String userId) {
        XN001400Req req = new XN001400Req();
        req.setTokenId(userId);
        req.setUserId(userId);
        XN001400Res res = BizConnecter.getBizData("001400",
            JsonUtils.object2Json(req), XN001400Res.class);
        if (res == null) {
            throw new BizException("XN000000", "编号为" + userId + "的用户不存在");
        }
        User user = new User();
        user.setUserId(res.getUserId());
        user.setLoginName(res.getLoginName());
        user.setNickname(res.getNickname());
        user.setPhoto(res.getPhoto());
        user.setMobile(res.getMobile());
        user.setIdentityFlag(res.getIdentityFlag());
        user.setUserReferee(res.getUserReferee());
        user.setLevel(res.getLevel());
        user.setKind(res.getKind());
        return user;
    }
}

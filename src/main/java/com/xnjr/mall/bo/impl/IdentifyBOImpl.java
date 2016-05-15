package com.xnjr.mall.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IIdentifyBO;
import com.xnjr.mall.dto.req.XN798001Req;
import com.xnjr.mall.dto.res.XN798001Res;
import com.xnjr.mall.http.BizConnecter;
import com.xnjr.mall.http.JsonUtils;

@Component
public class IdentifyBOImpl implements IIdentifyBO {
    static Logger logger = Logger.getLogger(IdentifyBOImpl.class);

    @Override
    public void doIdentify(String userId, String realName, String idKind,
            String idNo) {
        // try {
        XN798001Req req = new XN798001Req();
        req.setSystemId("1");
        req.setUserId(userId);
        req.setRealName(realName);
        req.setIdKind(idKind);
        req.setIdNo(idNo);
        req.setRemark("来自生意家-雄牛的实名认证");
        BizConnecter.getBizData("798001", JsonUtils.object2Json(req),
            XN798001Res.class);
        // } catch (Exception e) {
        // logger.error("调用实名认证服务异常");
        // }
    }
}

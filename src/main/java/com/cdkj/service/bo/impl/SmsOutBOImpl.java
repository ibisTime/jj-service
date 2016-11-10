package com.cdkj.service.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.dto.req.XN805905Req;
import com.cdkj.service.http.BizConnecter;
import com.cdkj.service.http.JsonUtils;

@Component
public class SmsOutBOImpl implements ISmsOutBO {
    static Logger logger = Logger.getLogger(SmsOutBOImpl.class);

    @Override
    public void sentContent(String tokenId, String ownerId, String content) {
        try {
            XN805905Req req = new XN805905Req();
            req.setTokenId(tokenId);
            req.setOwnerId(ownerId);
            req.setContent(content);
            BizConnecter.getBizData("805905", JsonUtils.object2Json(req),
                Object.class);
        } catch (Exception e) {
            logger.error("调用短信发送服务异常");
        }
    }
}

package com.cdkj.service.bo.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cdkj.service.bo.ISmsOutBO;
import com.cdkj.service.dto.req.XN001200Req;
import com.cdkj.service.http.BizConnecter;
import com.cdkj.service.http.JsonUtils;

@Component
public class SmsOutBOImpl implements ISmsOutBO {
    static Logger logger = Logger.getLogger(SmsOutBOImpl.class);

    @Override
    public void sentContent(String userId, String content) {
        try {
            XN001200Req req = new XN001200Req();
            req.setTokenId(userId);
            req.setUserId(userId);
            req.setContent(content);
            BizConnecter.getBizData("001200", JsonUtils.object2Json(req),
                Object.class);
        } catch (Exception e) {
            logger.error("调用短信发送服务异常,异常原因：" + e.getMessage());
        }
    }

}

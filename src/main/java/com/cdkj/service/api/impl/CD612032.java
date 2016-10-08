package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.CD612032Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 需求方对服务感兴趣
 * @author: zuixian 
 * @since: 2016年10月8日 下午1:48:29 
 * @history:
 */
public class CD612032 extends AProcessor {

    private IIntentionAO intentionAO = SpringContextHolder
        .getBean(IIntentionAO.class);

    private CD612032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return intentionAO.addIntention(req.getFromUser(), req.getToCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612032Req.class);
        StringValidater.validateBlank(req.getFromUser(), req.getToCode());
    }
}

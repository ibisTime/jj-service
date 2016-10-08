package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.CD612033Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 删除感兴趣关系
 * @author: zuixian 
 * @since: 2016年10月8日 下午1:48:29 
 * @history:
 */
public class CD612033 extends AProcessor {

    private IIntentionAO intentionAO = SpringContextHolder
        .getBean(IIntentionAO.class);

    private CD612033Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        int count = intentionAO.dropIntention(req.getCode());
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612033Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

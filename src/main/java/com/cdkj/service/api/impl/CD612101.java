package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.CD612101Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 个人对公司职位感兴趣，投递简历
 * @author: zuixian 
 * @since: 2016年10月8日 下午1:48:29 
 * @history:
 */
public class CD612101 extends AProcessor {

    private IIntentionAO intentionAO = SpringContextHolder
        .getBean(IIntentionAO.class);

    private CD612101Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return intentionAO.addZWIntention(req.getUserId(), req.getResumeCode(),
            req.getPositionCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612101Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getResumeCode(),
            req.getPositionCode());
    }
}

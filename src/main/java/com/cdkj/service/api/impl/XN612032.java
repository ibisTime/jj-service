package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612032Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 移组
 * @author: asus 
 * @since: 2017年6月4日 下午5:14:52 
 * @history:
 */
public class XN612032 extends AProcessor {
    private IFocusAO focusAO = SpringContextHolder.getBean(IFocusAO.class);

    private XN612032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        focusAO.editFocus(req.getCode(), req.getGroupCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612032Req.class);
        StringValidater.validateBlank(req.getCode(), req.getGroupCode());
    }
}

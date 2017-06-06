package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612133Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 热门位置上/下移
 * @author: zuixian 
 * @since: 2016年10月28日 上午10:38:49 
 * @history:
 */
public class CD612019 extends AProcessor {

    private IServeAO serveAO = SpringContextHolder.getBean(IServeAO.class);

    private XN612133Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        int count = serveAO
            .editServeHotLocation(req.getCode(), req.getAction());
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612133Req.class);
        StringValidater.validateBlank(req.getCode(), req.getAction());
    }
}

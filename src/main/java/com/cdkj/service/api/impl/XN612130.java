package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612130Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 删除服务
 * @author: asus 
 * @since: 2017年6月7日 下午2:27:05 
 * @history:
 */
public class XN612130 extends AProcessor {
    private IServeAO serveAO = SpringContextHolder.getBean(IServeAO.class);

    private XN612130Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        serveAO.dropServe(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612130Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

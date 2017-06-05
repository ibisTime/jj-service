package com.cdkj.service.api.impl;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612003Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 下架资讯
 * @author: asus 
 * @since: 2017年6月4日 下午3:55:28 
 * @history:
 */
public class XN612003 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN612003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        newsAO.soldOut(req.getCode(), req.getUpdater());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612003Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }

}

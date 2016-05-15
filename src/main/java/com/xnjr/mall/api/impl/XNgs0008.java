package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs0008Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 操盘手-详情查询
 * @author: myb858 
 * @since: 2016年1月13日 下午1:24:53 
 * @history:
 */
public class XNgs0008 extends AProcessor {
    private IGSTraderAO gsTraderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    XNgs0008Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gsTraderAO.getGSTrader(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0008Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}

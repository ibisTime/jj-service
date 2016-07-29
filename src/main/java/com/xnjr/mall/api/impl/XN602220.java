package com.xnjr.mall.api.impl;

import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XN602220Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;

/**
 * 新增分销引导记录
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:03:07 
 * @history:
 */
public class XN602220 extends AProcessor {

    private XN602220Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602220Req.class);
    }
}

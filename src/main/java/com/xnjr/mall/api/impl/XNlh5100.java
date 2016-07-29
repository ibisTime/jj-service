package com.xnjr.mall.api.impl;

import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XNlh5100Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;

/**
 * 新增分销引导记录
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:03:07 
 * @history:
 */
public class XNlh5100 extends AProcessor {

    private XNlh5100Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5100Req.class);
    }
}

package com.xnjr.mall.api.impl;

import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XNlh5101Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;

/**
 * 删除分销引导记录
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:21:14 
 * @history:
 */
public class XNlh5101 extends AProcessor {

    private XNlh5101Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5101Req.class);
    }
}

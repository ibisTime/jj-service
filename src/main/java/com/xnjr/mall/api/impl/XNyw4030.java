package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IWillInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4030Req;
import com.xnjr.mall.dto.res.XNyw4030Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.proxy.JsonUtil;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 意向认购
 * @author: xieyj 
 * @since: 2016年4月26日 下午2:04:43 
 * @history:
 */
public class XNyw4030 extends AProcessor {
    private IWillInvestAO willInvestAO = SpringContextHolder
        .getBean(IWillInvestAO.class);

    private XNyw4030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = willInvestAO.invest(req.getUserId(),
            req.getProjectCode(), StringValidater.toLong(req.getNowAmount()),
            req.getNowNote(), req.getTradePwd());
        return new XNyw4030Res(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4030Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getProjectCode(),
            req.getTradePwd());
    }
}

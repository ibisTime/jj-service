package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4020Req;
import com.xnjr.mall.dto.res.XNyw4020Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.proxy.JsonUtil;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 真实认购
 * @author: myb858 
 * @since: 2016年1月13日 上午10:18:48 
 * @history:
 */
public class XNyw4020 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    private XNyw4020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = investAO.invest(req.getUserId(), req.getProjectCode(),
            StringValidater.toLong(req.getInvestAmount()), req.getTradePwd());
        return new XNyw4020Res(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4020Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getProjectCode(),
            req.getTradePwd());
    }
}

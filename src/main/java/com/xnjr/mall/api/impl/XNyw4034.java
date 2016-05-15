package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IWillInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4034Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询意向认购详情
 * @author: xieyj 
 * @since: 2016年4月26日 下午2:50:48 
 * @history:
 */
public class XNyw4034 extends AProcessor {
    private IWillInvestAO willInvestAO = SpringContextHolder
        .getBean(IWillInvestAO.class);

    XNyw4034Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return willInvestAO.getInvest(req.getInvestCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4034Req.class);
        StringValidater.validateBlank(req.getInvestCode());
    }
}

package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4024Req;
import com.xnjr.mall.dto.res.XNyw4024Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 确定认购
 * @author: xieyj 
 * @since: 2016年4月26日 上午9:59:09 
 * @history:
 */
public class XNyw4024 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    private XNyw4024Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        investAO.confirmInvest(req.getInvestCode(),
            StringValidater.toLong(req.getInvestAmount()), req.getTradePwd(),
            req.getRemark());
        return new XNyw4024Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4024Req.class);
        StringValidater.validateAmount(req.getInvestAmount());
        StringValidater.validateBlank(req.getInvestCode(), req.getTradePwd(),
            req.getRemark());
    }
}

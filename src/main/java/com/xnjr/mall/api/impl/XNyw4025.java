package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4025Req;
import com.xnjr.mall.dto.res.XNyw4025Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 取消认购
 * @author: myb858 
 * @since: 2016年1月17日 下午4:15:14 
 * @history:
 */
public class XNyw4025 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    private XNyw4025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        investAO.cancelInvest(req.getInvestCode(), req.getTradePwd(),
            req.getRemark());
        return new XNyw4025Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4025Req.class);
        StringValidater.validateBlank(req.getInvestCode(), req.getTradePwd(),
            req.getRemark());

    }

}

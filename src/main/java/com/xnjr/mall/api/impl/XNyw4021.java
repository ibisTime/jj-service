package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4021Req;
import com.xnjr.mall.dto.res.XNyw4021Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 打款记录增加
 * @author: xieyj 
 * @since: 2016年4月26日 上午9:35:01 
 * @history:
 */
public class XNyw4021 extends AProcessor {
    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    private XNyw4021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String code = investTableAO.addInvestTable(req);
        return new XNyw4021Res(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4021Req.class);
        StringValidater.validateAmount(req.getAmount());
        StringValidater.validateBlank(req.getMoneyDatetime(),
            req.getInvestCode(), req.getFromCompany(),
            req.getFromCompanyCard(), req.getToCompany(),
            req.getToCompanyCard());
    }
}

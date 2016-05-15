package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4023Req;
import com.xnjr.mall.dto.res.XNyw4023Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 打款记录修改
 * @author: xieyj 
 * @since: 2016年4月26日 上午9:36:58 
 * @history:
 */
public class XNyw4023 extends AProcessor {
    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    private XNyw4023Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        investTableAO.editInvestTable(req);
        return new XNyw4023Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4023Req.class);
        StringValidater.validateAmount(req.getAmount());
        StringValidater.validateBlank(req.getMoneyDatetime(),
            req.getInvestCode(), req.getFromCompany(),
            req.getFromCompanyCard(), req.getToCompany(),
            req.getToCompanyCard());
    }

}

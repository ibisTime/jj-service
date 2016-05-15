package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAFJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccountFrozenJour;
import com.xnjr.mall.dto.req.XNfd0042Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

public class XNfd0042 extends AProcessor {

    private IFDAFJourAO fdAFJourAO = SpringContextHolder
        .getBean(IFDAFJourAO.class);

    private XNfd0042Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccountFrozenJour data = new FDAccountFrozenJour();
        data.setAccountNumber(req.getAccountNumber());
        data.setBizType(req.getBizType());
        data.setCreateDatetimeStart(DateUtil.getFrontDate(req.getDateStart(),
            false));
        data.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(), true));

        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdAFJourAO.queryAccountFrozenJourPage(start, limit, data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0042Req.class);
        StringValidater.validateBlank(req.getAccountNumber(), req.getStart(),
            req.getLimit());

    }

}

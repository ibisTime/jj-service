package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.dto.req.XNfd0041Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

public class XNfd0041 extends AProcessor {
    private IFDAJourAO fdAJourAO = SpringContextHolder
        .getBean(IFDAJourAO.class);

    private XNfd0041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccountJour data = new FDAccountJour();
        data.setAccountNumber(req.getAccountNumber());
        data.setBizType(req.getBizType());
        data.setCreateDatetimeStart(DateUtil.getFrontDate(req.getDateStart(),
            false));
        data.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(), true));

        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdAJourAO.queryAccountJourPage(start, limit, data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0041Req.class);
        StringValidater.validateBlank(req.getAccountNumber(), req.getStart(),
            req.getLimit());
    }

}

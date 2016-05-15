package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.InvestTable;
import com.xnjr.mall.dto.req.XNyw4035Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询打款记录详情
 * @author: duanjiewen
 * @since: 2016年4月28日 上午11:07:40 
 * @history:
 */
public class XNyw4035 extends AProcessor {

    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    private XNyw4035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        InvestTable data = new InvestTable();
        data.setInvestCode(req.getInvestTableCode());
        return investTableAO.getInvestTable(req.getInvestTableCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4035Req.class);
        StringValidater.validateBlank(req.getInvestTableCode());

    }

}

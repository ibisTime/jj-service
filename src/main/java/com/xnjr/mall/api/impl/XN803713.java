package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN803713Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询打款记录详情
 * @author: myb858 
 * @since: 2016年1月24日 下午1:26:29 
 * @history:
 */
public class XN803713 extends AProcessor {
    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    private XN803713Req req;

    @Override
    public Object doBusiness() throws BizException {
        return investTableAO.getInvestTable(req.getInvestTableCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN803713Req.class);
        StringValidater.validateBlank(req.getInvestTableCode());

    }

}

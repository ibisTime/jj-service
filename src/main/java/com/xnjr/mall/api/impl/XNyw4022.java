package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4022Req;
import com.xnjr.mall.dto.res.XNyw4022Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 打款记录删除
 * @author: xieyj 
 * @since: 2016年4月26日 上午9:35:28 
 * @history:
 */
public class XNyw4022 extends AProcessor {
    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    private XNyw4022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        investTableAO.dropInvestTable(req.getInvestTableCode());
        return new XNyw4022Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4022Req.class);
        StringValidater.validateBlank(req.getInvestTableCode());
    }
}

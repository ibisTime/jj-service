package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IHLOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5051Req;
import com.xnjr.mall.dto.res.XNlh5051Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 人工干预账户审批：还是需要对账的
 * @author: myb858 
 * @since: 2016年1月13日 下午8:18:50 
 * @history:
 */
public class XNlh5051 extends AProcessor {
    private IHLOrderAO hlOrderAO = SpringContextHolder
        .getBean(IHLOrderAO.class);

    private XNlh5051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        hlOrderAO.doApprove(req.getHlNo(), req.getUpdater(),
            req.getApproveResult(), req.getRemark());
        return new XNlh5051Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5051Req.class);
        StringValidater.validateBlank(req.getHlNo(), req.getUpdater(),
            req.getApproveResult(), req.getRemark());
    }

}

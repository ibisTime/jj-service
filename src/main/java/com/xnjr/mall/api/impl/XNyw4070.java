package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IRepayDetailAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4070Req;
import com.xnjr.mall.dto.res.XNyw4070Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 线下已还本付息的，进行还款：账户余额不变，但形成变动流水
 * @author: myb858 
 * @since: 2016年1月17日 下午5:05:21 
 * @history:
 */
public class XNyw4070 extends AProcessor {
    private IRepayDetailAO repayDetailAO = SpringContextHolder
        .getBean(IRepayDetailAO.class);

    private XNyw4070Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayDetailAO.repayShi(req.getRepayCode(), req.getRemark(),
            req.getTradePwd());
        return new XNyw4070Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4070Req.class);
        StringValidater.validateBlank(req.getRepayCode(), req.getRemark(),
            req.getTradePwd());
    }
}

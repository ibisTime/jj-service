package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDWithdrawAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0052Req;
import com.xnjr.mall.dto.res.XNfd0052Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss管理端-线下取现申请
 * @author: Gejin 
 * @since: 2016年4月27日 下午4:51:27 
 * @history:
 */
public class XNfd0052 extends AProcessor {

    private IFDWithdrawAO FDWithdrawAO = SpringContextHolder
        .getBean(IFDWithdrawAO.class);

    private XNfd0052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long amount = StringValidater.toLong(req.getAmount());
        return new XNfd0052Res(FDWithdrawAO.doWithdrawOSS(amount,
            req.getTowho(), req.getAccountNumber()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0052Req.class);
        StringValidater.validateBlank(req.getAccountNumber(), req.getAmount(),
            req.getTowho());
        StringValidater.validateAmount(req.getAmount());

    }

}

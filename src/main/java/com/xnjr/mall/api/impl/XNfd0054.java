package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDWithdrawAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0054Req;
import com.xnjr.mall.dto.res.XNfd0054Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 支付取现订单
 * @author: duanjiewen 
 * @since: 2016年4月27日 下午7:40:50 
 * @history:
 */
public class XNfd0054 extends AProcessor {
    private IFDWithdrawAO FDWithdrawAO = SpringContextHolder
        .getBean(IFDWithdrawAO.class);

    private XNfd0054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long payFree = StringValidater.toLong(req.getPayFee());
        FDWithdrawAO.doPayWithdraw(req.getQxNo(), req.getPayUser(),
            req.getPayResult(), req.getPayNote(), req.getPayNo(), payFree,
            req.getWorkDate());
        return new XNfd0054Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0054Req.class);
        StringValidater.validateBlank(req.getQxNo(), req.getPayUser(),
            req.getPayResult(), req.getPayNote(), req.getWorkDate());

    }

}

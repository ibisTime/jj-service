package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602104Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 积分切割兑换
 * @author: xieyj 
 * @since: 2016年7月21日 下午12:30:35 
 * @history:
 */
public class XN602104 extends AProcessor {
    private IIntegralAO integralAO = SpringContextHolder
        .getBean(IIntegralAO.class);

    private XN602104Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        integralAO.scannIntegral(req.getIntegralCode(), req.getUserId());
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602104Req.class);
        StringValidater.validateBlank(req.getIntegralCode(), req.getUserId());
    }

}

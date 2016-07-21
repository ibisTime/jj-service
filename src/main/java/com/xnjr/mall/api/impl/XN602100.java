package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Integral;
import com.xnjr.mall.dto.req.XN602100Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 形成积分块
 * @author: xieyj 
 * @since: 2016年7月21日 上午11:00:45 
 * @history:
 */
public class XN602100 extends AProcessor {

    private IIntegralAO integralAO = SpringContextHolder
        .getBean(IIntegralAO.class);

    private XN602100Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Integral data = new Integral();
        data.setUserId(req.getUserId());
        data.setQuantity(Long.valueOf(req.getQuantity()));
        data.setPrice(Long.valueOf(req.getPrice()));
        data.setIsApprove(req.getIsApprove());
        data.setRemark(req.getRemark());
        return new PKCodeRes(integralAO.addIntegral(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602100Req.class);
        StringValidater.validateAmount(req.getQuantity(), req.getPrice());
        StringValidater.validateBlank(req.getUserId(), req.getIsApprove());
    }

}

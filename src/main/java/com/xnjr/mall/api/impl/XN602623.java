package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602623Req;
import com.xnjr.mall.dto.res.XN602623Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * (前端购买)扫描积分二维码，需审批产生积分申请；无需审批直接从商家里扣除积分，直接加上
 * @author: xieyj 
 * @since: 2016年7月22日 下午2:43:16 
 * @history:
 */
public class XN602623 extends AProcessor {
    private IIntegralAO integralAO = SpringContextHolder
        .getBean(IIntegralAO.class);

    private XN602623Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        String count = integralAO.bugIntegral(req.getIntegralCode(),
            req.getUserId());
        return new XN602623Res(count);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602623Req.class);
        StringValidater.validateBlank(req.getIntegralCode(), req.getUserId());
    }

}

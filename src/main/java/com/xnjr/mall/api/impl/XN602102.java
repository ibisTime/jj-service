package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.Integral;
import com.xnjr.mall.dto.req.XN602102Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 积分块列表查询
 * @author: xieyj 
 * @since: 2016年7月21日 上午11:10:20 
 * @history:
 */
public class XN602102 extends AProcessor {
    private IIntegralAO integralAO = SpringContextHolder
        .getBean(IIntegralAO.class);

    private XN602102Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Integral condition = new Integral();
        condition.setUserId(req.getUserId());
        condition.setIsApprove(req.getIsApprove());
        condition.setStatus(req.getStatus());
        return integralAO.queryIntegralList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602102Req.class);
    }
}

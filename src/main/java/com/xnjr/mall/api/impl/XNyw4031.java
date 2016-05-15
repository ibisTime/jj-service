package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IWillInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.WillInvest;
import com.xnjr.mall.dto.req.XNyw4031Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.proxy.JsonUtil;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 我的意向认购
 * @author: xieyj 
 * @since: 2016年4月26日 下午2:04:43 
 * @history:
 */
public class XNyw4031 extends AProcessor {
    private IWillInvestAO willInvestAO = SpringContextHolder
        .getBean(IWillInvestAO.class);

    private XNyw4031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        WillInvest condition = new WillInvest();
        condition.setUserId(req.getUserId());
        condition.setStatus(req.getStatus());
        return willInvestAO.queryMyInvestList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4031Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}

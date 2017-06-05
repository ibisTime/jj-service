package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IBcIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.dto.req.XN612203Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 处理BC意向
 * @author: asus 
 * @since: 2017年6月5日 下午5:44:12 
 * @history:
 */
public class XN612203 extends AProcessor {
    private IBcIntentionAO bcIntentionAO = SpringContextHolder
        .getBean(IBcIntentionAO.class);

    private XN612203Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        // TODO Auto-generated method stub

    }

}

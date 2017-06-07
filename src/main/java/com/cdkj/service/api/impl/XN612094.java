package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612094Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 培训服务热门设置
 * @author: asus 
 * @since: 2017年6月7日 下午3:25:54 
 * @history:
 */
public class XN612094 extends AProcessor {

    private ITrainAO trainAO = SpringContextHolder.getBean(ITrainAO.class);

    private XN612094Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        trainAO.editLocation(req.getCode(), req.getLocation(),
            req.getOrderNo(), req.getDealer());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612094Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLocation(),
            req.getOrderNo(), req.getDealer());
    }
}

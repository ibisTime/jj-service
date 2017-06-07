package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612154Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 职位热门设置
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class XN612154 extends AProcessor {

    private IPositionAO positionAO = SpringContextHolder
        .getBean(IPositionAO.class);

    private XN612154Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        positionAO.editPositionHot(req.getCode(), null, req.getOrderNo(),
            req.getDealer());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612154Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDealer());
    }
}

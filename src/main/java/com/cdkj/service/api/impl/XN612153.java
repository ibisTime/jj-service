package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612153Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 职位违规处理，状态更改为违规
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class XN612153 extends AProcessor {

    private IPositionAO positionAO = SpringContextHolder
        .getBean(IPositionAO.class);

    private XN612153Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        positionAO.editPositionStatus(req.getCode(), req.getDealer(),
            req.getDealNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612153Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDealer(),
            req.getDealNote());
    }
}

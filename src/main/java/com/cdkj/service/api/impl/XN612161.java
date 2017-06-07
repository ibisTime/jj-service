package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612161Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询职位
 * @author: asus 
 * @since: 2017年6月7日 上午9:48:59 
 * @history:
 */
public class XN612161 extends AProcessor {

    private IPositionAO positionAO = SpringContextHolder
        .getBean(IPositionAO.class);

    private XN612161Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return positionAO.getPosition(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612161Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

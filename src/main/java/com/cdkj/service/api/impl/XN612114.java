package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612114Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 店铺代运营服务热门设置
 * @author: asus 
 * @since: 2017年6月7日 上午10:22:32 
 * @history:
 */
public class XN612114 extends AProcessor {

    private IOperateAO operateAO = SpringContextHolder
        .getBean(IOperateAO.class);

    private XN612114Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        operateAO.editLocation(req.getCode(), req.getLocation(),
            req.getOrderNo(), req.getDealer());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612114Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLocation(),
            req.getOrderNo(), req.getDealer());
    }
}

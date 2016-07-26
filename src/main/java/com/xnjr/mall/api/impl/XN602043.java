package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ILogisticsAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602043Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 物流单-确认收货
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:19:39 
 * @history:
 */
public class XN602043 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN602043Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(logisticsAO.confirmLogistics(req.getCode(),
            req.getUpdater(), req.getRemark()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602043Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}

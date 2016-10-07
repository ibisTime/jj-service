package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.CD612043Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 需求违规处理
 * @author: xieyj 
 * @since: 2016年10月7日 下午6:03:47 
 * @history:
 */
public class CD612043 extends AProcessor {

    private IDemandAO demandAO = SpringContextHolder.getBean(IDemandAO.class);

    private CD612043Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        demandAO.violationDemand(req.getCode(), req.getDealer(),
            req.getDealNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612043Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDealer(),
            req.getDealNote());
    }
}

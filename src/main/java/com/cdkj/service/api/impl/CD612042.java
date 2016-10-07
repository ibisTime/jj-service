package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.CD612042Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 删除需求
 * @author: xieyj 
 * @since: 2016年10月7日 下午6:03:47 
 * @history:
 */
public class CD612042 extends AProcessor {

    private IDemandAO demandAO = SpringContextHolder.getBean(IDemandAO.class);

    private CD612042Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        demandAO.dropDemand(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612042Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

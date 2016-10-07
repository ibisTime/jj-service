package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.CD612051Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 需求-详情查询
 * @author: xieyj 
 * @since: 2016年5月16日 下午9:38:19 
 * @history:
 */
public class CD612051 extends AProcessor {
    private IDemandAO demandAO = SpringContextHolder.getBean(IDemandAO.class);

    private CD612051Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return demandAO.getDemand(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612051Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

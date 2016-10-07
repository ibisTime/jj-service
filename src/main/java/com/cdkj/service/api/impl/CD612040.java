package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.DemandConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.dto.req.CD612040Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增需求
 * @author: xieyj 
 * @since: 2016年10月7日 下午6:03:47 
 * @history:
 */
public class CD612040 extends AProcessor {

    private IDemandAO demandAO = SpringContextHolder.getBean(IDemandAO.class);

    private CD612040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Demand data = DemandConverter.converter(req);
        String code = demandAO.addDemand(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612040Req.class);
        StringValidater.validateBlank(req.getName(), req.getQualityCode(),
            req.getUrgentLevel(), req.getDescription(), req.getPublisher());
    }
}

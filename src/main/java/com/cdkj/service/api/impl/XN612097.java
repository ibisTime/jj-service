package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612097Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:24:22 
 * @history:
 */
public class XN612097 extends AProcessor {

    private ITrainAO trainAO = SpringContextHolder.getBean(ITrainAO.class);

    private XN612097Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return trainAO.getTrain(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612097Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

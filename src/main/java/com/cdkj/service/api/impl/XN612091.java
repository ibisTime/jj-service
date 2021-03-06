package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612091Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 删除培训服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:21:56 
 * @history:
 */
public class XN612091 extends AProcessor {

    private ITrainAO trainAO = SpringContextHolder.getBean(ITrainAO.class);

    private XN612091Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        trainAO.dropTrain(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612091Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

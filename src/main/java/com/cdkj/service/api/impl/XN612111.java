package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612111Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 删除店铺代运营服务
 * @author: asus 
 * @since: 2017年6月7日 上午11:32:27 
 * @history:
 */
public class XN612111 extends AProcessor {
    private IOperateAO operateAO = SpringContextHolder
        .getBean(IOperateAO.class);

    private XN612111Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        operateAO.dropOperate(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612111Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

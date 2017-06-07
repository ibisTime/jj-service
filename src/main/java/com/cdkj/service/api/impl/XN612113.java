package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IOperateAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612113Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 服务违规处理，状态更改为违规
 * @author: asus 
 * @since: 2017年6月7日 上午10:22:32 
 * @history:
 */
public class XN612113 extends AProcessor {

    private IOperateAO operateAO = SpringContextHolder
        .getBean(IOperateAO.class);

    private XN612113Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        operateAO
            .wgclOperate(req.getCode(), req.getDealer(), req.getDealNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612113Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDealer(),
            req.getDealNote());
    }
}

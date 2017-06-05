package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612012Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改资质
 * @author: asus 
 * @since: 2017年6月4日 下午4:14:45 
 * @history:
 */
public class XN612012 extends AProcessor {
    private IQualifyAO qualifyAO = SpringContextHolder
        .getBean(IQualifyAO.class);

    private XN612012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        qualifyAO.editQualify(req.getCode(), req.getType(), req.getName(),
            req.getDescription(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612012Req.class);
        StringValidater.validateBlank(req.getCode(), req.getType(),
            req.getName(), req.getDescription(), req.getUpdater());
    }

}

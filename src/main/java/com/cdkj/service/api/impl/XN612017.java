package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612017Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询资质
 * @author: asus 
 * @since: 2017年6月4日 下午4:16:52 
 * @history:
 */
public class XN612017 extends AProcessor {
    private IQualifyAO qualifyAO = SpringContextHolder
        .getBean(IQualifyAO.class);

    private XN612017Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return qualifyAO.getQualify(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612017Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

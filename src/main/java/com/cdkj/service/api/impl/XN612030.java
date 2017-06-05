package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612030Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 关注
 * @author: asus 
 * @since: 2017年6月4日 下午5:12:03 
 * @history:
 */
public class XN612030 extends AProcessor {
    private IFocusAO focusAO = SpringContextHolder.getBean(IFocusAO.class);

    private XN612030Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(focusAO.addFocus(req.getCompanyCode(),
            req.getGroupCode(), req.getUserId()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612030Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getGroupCode(),
            req.getUserId());
    }
}

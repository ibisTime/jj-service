package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612031Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 取消关注
 * @author: asus 
 * @since: 2017年6月4日 下午5:13:42 
 * @history:
 */
public class XN612031 extends AProcessor {
    private IFocusAO focusAO = SpringContextHolder.getBean(IFocusAO.class);

    private XN612031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        focusAO.dropFocus(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612031Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

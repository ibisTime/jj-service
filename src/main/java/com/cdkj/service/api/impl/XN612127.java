package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612127Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改软件外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:20:00 
 * @history:
 */
public class XN612127 extends AProcessor {

    private IServeAO serveAO = SpringContextHolder.getBean(IServeAO.class);

    private XN612127Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        serveAO.editServe(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612127Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getAdvPic(), req.getQuoteMin(),
            req.getQuoteMax(), req.getPublisher());
    }
}

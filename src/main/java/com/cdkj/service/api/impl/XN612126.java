package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612126Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增软件外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:19:28 
 * @history:
 */
public class XN612126 extends AProcessor {

    private IServeAO serveAO = SpringContextHolder.getBean(IServeAO.class);

    private XN612126Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(serveAO.addServe(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612126Req.class);
        StringValidater.validateBlank(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(), req.getQuoteMin(),
            req.getQuoteMax(), req.getQualityCode(), req.getPublisher());
    }
}

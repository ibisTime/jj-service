package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeArtAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612121Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改美工外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:16:53 
 * @history:
 */
public class XN612121 extends AProcessor {

    private IServeArtAO serveArtAO = SpringContextHolder
        .getBean(IServeArtAO.class);

    private XN612121Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        serveArtAO.editServeArt(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612121Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getAdvPic(), req.getQuoteMin(),
            req.getQuoteMax(), req.getDesignNum(), req.getSclm(),
            req.getHomeDays(), req.getHomePrice(), req.getDetailDays(),
            req.getDetailPrice(), req.getBannerDays(), req.getBannerPrice(),
            req.getAllDays(), req.getAllPrice(), req.getWorks(),
            req.getPublisher());
    }
}

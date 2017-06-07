package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeArtAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612120Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增美工外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:16:09 
 * @history:
 */
public class XN612120 extends AProcessor {

    private IServeArtAO serveArtAO = SpringContextHolder
        .getBean(IServeArtAO.class);

    private XN612120Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(serveArtAO.addServeArt(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612120Req.class);
        StringValidater.validateBlank(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(), req.getQuoteMin(),
            req.getQuoteMax(), req.getQualityCode(), req.getDesignNum(),
            req.getSclm(), req.getHomeDays(), req.getHomePrice(),
            req.getDetailDays(), req.getDetailPrice(), req.getBannerDays(),
            req.getBannerPrice(), req.getAllDays(), req.getAllPrice(),
            req.getWorks(), req.getPublisher());
    }
}

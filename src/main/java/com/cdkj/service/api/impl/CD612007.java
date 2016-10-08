package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeArtAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeArt;
import com.cdkj.service.dto.req.CD612007Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 修改美工外包
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612007 extends AProcessor {

    private IServeArtAO serveArtAO = SpringContextHolder
        .getBean(IServeArtAO.class);

    private CD612007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeArt data = ServeConverter.converter(req);
        int count = serveArtAO.editServeArt(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612007Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getDesignNum(),
            req.getSclm(), req.getHomeDays(), req.getHomePrice(),
            req.getDetailDays(), req.getDetailPrice(), req.getBannerDays(),
            req.getBannerPrice(), req.getAllDays(), req.getAllPrice(),
            req.getWorks(), req.getPublisher());
    }
}

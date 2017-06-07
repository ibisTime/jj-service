package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServePhotoAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.dto.req.XN612080Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增摄影/拍摄服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:13:47 
 * @history:
 */
public class XN612080 extends AProcessor {

    private IServePhotoAO servePhotoAO = SpringContextHolder
        .getBean(IServePhotoAO.class);

    private XN612080Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServePhoto data = ServeConverter.converter(req);
        String code = servePhotoAO.addServePhoto(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612080Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getPyNum(), req.getSysNum(), req.getIsDz(), req.getScpslm(),
            req.getWorks(), req.getPublisher());
    }
}

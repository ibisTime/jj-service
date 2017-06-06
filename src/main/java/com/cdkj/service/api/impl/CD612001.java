package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServePhotoAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServePhoto;
import com.cdkj.service.dto.req.XN612082Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 修改摄影/拍摄服务
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612001 extends AProcessor {

    private IServePhotoAO servePhotoAO = SpringContextHolder
        .getBean(IServePhotoAO.class);

    private XN612082Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServePhoto data = ServeConverter.converter(req);
        int count = servePhotoAO.editServePhoto(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612082Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getPyNum(),
            req.getSysNum(), req.getIsDz(), req.getScpslm(), req.getWorks(),
            req.getPublisher());
    }
}

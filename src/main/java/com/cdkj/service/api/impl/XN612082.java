package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612082Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改摄影/拍摄服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:14:15 
 * @history:
 */
public class XN612082 extends AProcessor {

    private IPhotoAO photoAO = SpringContextHolder.getBean(IPhotoAO.class);

    private XN612082Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        photoAO.editPhoto(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612082Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getAdvPic(), req.getQuoteMin(),
            req.getQuoteMax(), req.getPyNum(), req.getSysNum(), req.getIsDz(),
            req.getScpslm(), req.getWorks(), req.getPublisher());
        StringValidater.validateEmoji(req.getDescription());
    }
}

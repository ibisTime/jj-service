package com.cdkj.service.api.impl;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612000Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增资讯
 * @author: asus 
 * @since: 2017年6月4日 下午3:55:00 
 * @history:
 */
public class XN612000 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN612000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(newsAO.addNews(req.getTitle(), req.getType(),
            req.getSendPlatform(), req.getSummary(), req.getContent(),
            req.getIsPublish(), req.getUpdater(), req.getRemark()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612000Req.class);
        StringValidater.validateBlank(req.getTitle(), req.getType(),
            req.getSendPlatform(), req.getSummary(), req.getContent(),
            req.getIsPublish(), req.getUpdater());
    }

}

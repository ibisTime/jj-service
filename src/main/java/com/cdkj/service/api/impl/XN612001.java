package com.cdkj.service.api.impl;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612001Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改资讯
 * @author: asus 
 * @since: 2017年6月4日 下午3:54:46 
 * @history:
 */
public class XN612001 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN612001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        newsAO.editNews(req.getCode(), req.getTitle(), req.getType(),
            req.getSendPlatform(), req.getSummary(), req.getContent(),
            req.getIsPublish(), req.getUpdater(), req.getRemark());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612001Req.class);
        StringValidater.validateBlank(req.getCode(), req.getTitle(),
            req.getType(), req.getSendPlatform(), req.getSummary(),
            req.getContent(), req.getIsPublish(), req.getUpdater());
    }

}

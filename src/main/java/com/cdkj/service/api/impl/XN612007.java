package com.cdkj.service.api.impl;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612007Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询资讯
 * @author: asus 
 * @since: 2017年6月4日 下午4:01:22 
 * @history:
 */
public class XN612007 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN612007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return newsAO.getNews(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612007Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

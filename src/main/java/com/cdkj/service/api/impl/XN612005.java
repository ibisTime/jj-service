package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.INewsAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.News;
import com.cdkj.service.dto.req.XN612005Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询资讯
 * @author: asus 
 * @since: 2017年6月4日 下午4:01:43 
 * @history:
 */
public class XN612005 extends AProcessor {
    private INewsAO newsAO = SpringContextHolder.getBean(INewsAO.class);

    private XN612005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        News condition = new News();
        condition.setType(req.getType());
        condition.setTitle(req.getTitle());
        condition.setSummary(req.getSummary());
        condition.setStatus(req.getStatus());
        condition.setSendPlatform(req.getSendPlatform());
        condition.setUpdater(req.getUpdater());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = INewsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return newsAO.queryNewsPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612005Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

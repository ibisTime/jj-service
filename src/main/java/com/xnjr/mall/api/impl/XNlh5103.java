package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.ISaleGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.api.converter.SaleGuideConverter;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.SaleGuide;
import com.xnjr.mall.dto.req.XNlh5103Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询分销引导表
 * @author: xieyj 
 * @since: 2016年7月29日 下午1:23:25 
 * @history:
 */
public class XNlh5103 extends AProcessor {

    private ISaleGuideAO saleGuideAO = SpringContextHolder
        .getBean(ISaleGuideAO.class);

    private XNlh5103Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        SaleGuide condition = SaleGuideConverter.converter(req);
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISaleGuideAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return saleGuideAO.querySaleGuidePage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5103Req.class);
    }
}

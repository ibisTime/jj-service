package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSStructure;
import com.xnjr.mall.dto.req.XNgs4003Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询结构
 * @author: Gejin 
 * @since: 2016年4月13日 下午3:56:39 
 * @history:
 */
public class XNgs4003 extends AProcessor {

    private IGSStructureAO gsStructureAO = SpringContextHolder
        .getBean(IGSStructureAO.class);

    private XNgs4003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSStructure data = new GSStructure();
        data.setName(req.getName());
        data.setStatus(req.getStatus());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IGSStructureAO.DEFAULT_ORDER_COLUMN;
        }
        data.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return gsStructureAO.queryStructurePage(start, limit, data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs4003Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());

    }

}

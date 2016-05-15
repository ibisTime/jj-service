package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IGSAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSAccountJour;
import com.xnjr.mall.dto.req.XNgs0021Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询系统账户流水
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午5:09:54 
 * @history:
 */
public class XNgs0021 extends AProcessor {
    private IGSAJourAO gsAJourAO = SpringContextHolder
        .getBean(IGSAJourAO.class);

    private XNgs0021Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSAccountJour condition = new GSAccountJour();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setStatus(req.getStatus());
        condition.setBizType(req.getBizType());
        condition.setRefNo(req.getRefNo());
        condition.setWorkDate(req.getWorkDate());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = gsAJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return gsAJourAO.queryGSAccountJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0021Req.class);
        StringValidater.validateNumber(req.getAccountNumber(), req.getStart(),
            req.getLimit());

    }

}

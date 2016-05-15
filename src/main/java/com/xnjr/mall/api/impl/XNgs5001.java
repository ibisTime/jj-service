package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IGSAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSAccountJour;
import com.xnjr.mall.dto.req.XNgs5001Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询系统账户流水
 * @author: myb858 
 * @since: 2016年1月21日 下午8:03:18 
 * @history:
 */
public class XNgs5001 extends AProcessor {
    private IGSAJourAO gsAJourAO = SpringContextHolder
        .getBean(IGSAJourAO.class);

    private XNgs5001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSAccountJour condition = new GSAccountJour();
        condition.setStatus(req.getStatus());
        condition.setBizType(req.getBizType());
        condition.setRefNo(req.getRefNo());
        condition.setCheckUser(req.getCheckUser());
        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGSAJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return gsAJourAO.queryGSAccountJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs5001Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());

    }

}

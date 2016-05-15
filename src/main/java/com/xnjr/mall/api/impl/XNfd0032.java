package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDAFJourAO;
import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccountFrozenJour;
import com.xnjr.mall.dto.req.XNfd0032Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * front-分页查询冻结资金流水
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:17 
 * @history:
 */
public class XNfd0032 extends AProcessor {

    private IFDAFJourAO fdAFJourAO = SpringContextHolder
        .getBean(IFDAFJourAO.class);

    private XNfd0032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccountFrozenJour condition = new FDAccountFrozenJour();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setBizType(req.getBizType());
        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFDAJourAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdAFJourAO.queryAccountFrozenJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0032Req.class);
        StringValidater.validateBlank(req.getAccountNumber());
    }
}

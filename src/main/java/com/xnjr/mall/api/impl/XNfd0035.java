package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.dto.req.XNfd0035Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-分页查询资金流水
 * @author: myb858 
 * @since: 2015年10月29日 下午1:57:45 
 * @history:
 */
public class XNfd0035 extends AProcessor {
    private IFDAJourAO aFJourAO = SpringContextHolder.getBean(IFDAJourAO.class);

    private XNfd0035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccountJour condition = new FDAccountJour();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setAjNo(StringValidater.toLong(req.getAjNo()));
        condition.setStatus(req.getStatus());
        condition.setBizType(req.getBizType());
        condition.setRefNo(req.getRefNo());

        condition.setWorkDate(req.getWorkDate());
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
        return aFJourAO.queryAccountJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0035Req.class);
    }
}

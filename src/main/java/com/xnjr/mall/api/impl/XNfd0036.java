package com.xnjr.mall.api.impl;

import org.apache.commons.lang.StringUtils;

import com.xnjr.mall.ao.IFDAFJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccountFrozenJour;
import com.xnjr.mall.dto.req.XNfd0036Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-分页查询冻结资金流水
 * @author: myb858 
 * @since: 2015年10月29日 下午1:57:45 
 * @history:
 */
public class XNfd0036 extends AProcessor {
    private IFDAFJourAO fdAFJourAO = SpringContextHolder
        .getBean(IFDAFJourAO.class);

    private XNfd0036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccountFrozenJour condition = new FDAccountFrozenJour();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setAfjNo(StringValidater.toLong(req.getAfjNo()));
        condition.setBizType(req.getBizType());
        condition.setRefNo(req.getRefNo());

        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFDAFJourAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdAFJourAO.queryAccountFrozenJourPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0036Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());

    }

}

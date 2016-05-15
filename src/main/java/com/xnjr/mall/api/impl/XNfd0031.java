package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.dto.req.XNfd0031Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * front-分页查询资金流水
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:17 
 * @history:
 */
public class XNfd0031 extends AProcessor {

    private IFDAJourAO fdAJourAO = SpringContextHolder
        .getBean(IFDAJourAO.class);

    private XNfd0031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccountJour condition = new FDAccountJour();
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
        return fdAJourAO.queryFrontAccountJourPage(start, limit,
            req.getUserId(), condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0031Req.class);
        StringValidater.validateBlank(req.getUserId());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

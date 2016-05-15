package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IHLOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.HLOrder;
import com.xnjr.mall.dto.req.XNlh5052Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询红冲蓝补订单
 * @author: myb858 
 * @since: 2015年10月27日 下午3:53:27 
 * @history:
 */
public class XNlh5052 extends AProcessor {
    private IHLOrderAO hlOrderAO = SpringContextHolder
        .getBean(IHLOrderAO.class);

    private XNlh5052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        HLOrder condition = new HLOrder();

        condition.setHlNo(req.getHlNo());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());
        condition.setDirection(req.getDirection());
        condition.setUpdater(req.getUpdater());
        condition.setAccountNumber(req.getAccountNumber());
        condition.setUpdateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setUpdateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IHLOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return hlOrderAO.queryHLOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5052Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());

    }

}

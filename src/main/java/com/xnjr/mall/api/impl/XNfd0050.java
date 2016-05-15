package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDWithdrawAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDWithdraw;
import com.xnjr.mall.dto.req.XNfd0050Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询取现订单
 * @author: duanjiewen
 * @since: 2016年4月27日 下午7:57:42 
 * @history:
 */
public class XNfd0050 extends AProcessor {
    private IFDWithdrawAO FDWithdrawAO = SpringContextHolder
        .getBean(IFDWithdrawAO.class);

    private XNfd0050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDWithdraw data = new FDWithdraw();
        data.setAccountNumber(req.getAccountNumber());
        data.setCreateDatetimeStart(DateUtil.getFrontDate(req.getDateStart(),
            false));
        data.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(), true));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFDWithdrawAO.DEFAULT_ORDER_COLUMN;
        }
        data.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return FDWithdrawAO.queryWithdrawPage(start, limit, data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0050Req.class);
        StringValidater.validateBlank(req.getAccountNumber());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

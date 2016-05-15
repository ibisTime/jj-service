package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSTrader;
import com.xnjr.mall.dto.req.XNgs0006Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 操盘手-分页查询
 * @author: myb858 
 * @since: 2016年1月13日 下午1:25:07 
 * @history:
 */
public class XNgs0006 extends AProcessor {
    private IGSTraderAO gsTraderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    XNgs0006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSTrader condition = new GSTrader();
        condition.setMobile(req.getMobile());
        condition.setRealName(req.getRealName());
        condition.setLevel(req.getLevel());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IGSTraderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return gsTraderAO.queryGSTraderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0006Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

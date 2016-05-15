package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.ao.IWillInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.WillInvest;
import com.xnjr.mall.dto.req.XNyw4032Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询意向认购列表
 * @author: xieyj 
 * @since: 2016年4月26日 下午2:50:48 
 * @history:
 */
public class XNyw4032 extends AProcessor {
    private IWillInvestAO willInvestAO = SpringContextHolder
        .getBean(IWillInvestAO.class);

    XNyw4032Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        WillInvest condition = new WillInvest();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setProjectCode(req.getProjectCode());
        condition.setUserId(req.getUserId());

        condition.setRealName(req.getRealName());
        condition.setInvestDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setInvestDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IInvestAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return willInvestAO.queryInvestPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4032Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}

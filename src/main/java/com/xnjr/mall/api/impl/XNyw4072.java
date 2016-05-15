package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IRepayDetailAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.RepayDetail;
import com.xnjr.mall.dto.req.XNyw4072Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询还款列表
 * @author: myb858 
 * @since: 2016年1月21日 下午7:48:10 
 * @history:
 */
public class XNyw4072 extends AProcessor {
    private IRepayDetailAO repayDetailAO = SpringContextHolder
        .getBean(IRepayDetailAO.class);

    private XNyw4072Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        RepayDetail condition = new RepayDetail();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setTowho(req.getTowho());
        condition.setTowhoName(req.getTowhoName());

        condition.setBusinessCode(req.getBusinessCode());
        condition.setSubjectCode(req.getSubjectCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IRepayDetailAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());

        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return repayDetailAO.queryRepayDetailPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4072Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}

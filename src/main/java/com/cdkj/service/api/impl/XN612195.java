package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.DateUtil;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.dto.req.XN612195Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 需求-分页查询
 * @author: xieyj 
 * @since: 2016年10月7日 下午6:10:20 
 * @history:
 */
public class XN612195 extends AProcessor {
    private IDemandAO demandAO = SpringContextHolder.getBean(IDemandAO.class);

    private XN612195Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Demand condition = new Demand();
        condition.setMobile(req.getMobile());
        condition.setPublisher(req.getPublisher());
        condition.setStatus(req.getStatus());
        condition.setQualityCode(req.getQualityCode());
        condition.setExpCompany(req.getCompanyCode());

        condition.setType(req.getType());
        condition.setUrgentLevel(req.getUrgentLevel());
        condition.setPublishDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setPublishDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        condition.setDealer(req.getDealer());

        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IDemandAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return demandAO.queryDemandPage(start, limit, condition);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612195Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IDemandAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.DemandConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.dto.req.CD612050Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 需求-分页查询
 * @author: xieyj 
 * @since: 2016年10月7日 下午6:10:20 
 * @history:
 */
public class CD612050 extends AProcessor {
    private IDemandAO demandAO = SpringContextHolder.getBean(IDemandAO.class);

    private CD612050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Demand condition = DemandConverter.converter(req);
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IDemandAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());

        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return demandAO.queryDemandPage(start, limit, condition);

    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612050Req.class);
    }
}

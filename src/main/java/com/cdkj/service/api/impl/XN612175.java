package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.ICbIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.CbIntention;
import com.cdkj.service.dto.req.XN612175Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询CB意向
 * @author: asus 
 * @since: 2017年6月7日 下午6:28:20 
 * @history:
 */
public class XN612175 extends AProcessor {
    private ICbIntentionAO cbIntentionAO = SpringContextHolder
        .getBean(ICbIntentionAO.class);

    private XN612175Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        CbIntention condition = new CbIntention();
        condition.setType(req.getType());
        condition.setIntName(req.getIntName());
        condition.setIntMobile(req.getIntMobile());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setServiceCode(req.getServiceCode());
        condition.setPositionCode(req.getPositionCode());
        condition.setResumeCode(req.getResumeCode());
        condition.setStatus(req.getStatus());
        condition.setSubmitter(req.getSubmitter());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICbIntentionAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return cbIntentionAO.queryCbIntentionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612175Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

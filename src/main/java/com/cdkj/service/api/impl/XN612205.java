package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IBcIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.BcIntention;
import com.cdkj.service.dto.req.XN612205Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询BC意向
 * @author: asus 
 * @since: 2017年6月5日 下午5:44:12 
 * @history:
 */
public class XN612205 extends AProcessor {
    private IBcIntentionAO bcIntentionAO = SpringContextHolder
        .getBean(IBcIntentionAO.class);

    private XN612205Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        BcIntention condition = new BcIntention();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setDemandCode(req.getDemandCode());
        condition.setResumeCode(req.getResumeCode());
        condition.setStatus(req.getStatus());
        condition.setSubmitter(req.getSubmiter());
        condition.setGsUserId(req.getGsUserId());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBcIntentionAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return bcIntentionAO.queryBcIntentionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612205Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

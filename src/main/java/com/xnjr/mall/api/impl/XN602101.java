package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Integral;
import com.xnjr.mall.dto.req.XN602101Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 积分二维码分页查询
 * @author: xieyj 
 * @since: 2016年7月21日 上午11:10:20 
 * @history:
 */
public class XN602101 extends AProcessor {
    private IIntegralAO integralAO = SpringContextHolder
        .getBean(IIntegralAO.class);

    private XN602101Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Integral condition = new Integral();
        condition.setUserId(req.getUserId());
        condition.setIsApprove(req.getIsApprove());
        condition.setStatus(req.getStatus());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IIntegralAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return integralAO.queryIntegralPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602101Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}

package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IMerCardAO;
import com.xnjr.mall.ao.ISYSDictAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.MerCard;
import com.xnjr.mall.dto.req.XN602403Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 受款账号-分页查询
 * @author: xieyj 
 * @since: 2016年6月11日 下午6:39:33 
 * @history:
 */
public class XN602403 extends AProcessor {
    private IMerCardAO merCardAO = SpringContextHolder
        .getBean(IMerCardAO.class);

    private XN602403Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        MerCard condition = new MerCard();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setSubbranchForQuery(req.getSubbranch());
        condition.setCardNoForQuery(req.getCardNo());
        condition.setStatus(req.getStatus());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISYSDictAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return merCardAO.queryMerCardPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602403Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IGoodsOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.dto.req.XN602122Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询货订单
 * @author: xieyj 
 * @since: 2016年7月21日 下午2:13:40 
 * @history:
 */
public class XN602122 extends AProcessor {

    private IGoodsOrderAO goodsOrderAO = SpringContextHolder
        .getBean(IGoodsOrderAO.class);

    private XN602122Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GoodsOrder condition = new GoodsOrder();
        condition.setCode(req.getCode());
        condition.setGoodsCode(req.getGoodsCode());
        condition.setStatus(req.getStatus());
        condition.setApplyUser(req.getApplyUser());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IGoodsOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return goodsOrderAO.queryGoodsOrderPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602122Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

/**
 * @Title XN602061.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:20:37 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IGoodsAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Goods;
import com.xnjr.mall.dto.req.XN602061Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 货分页查询
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:20:37 
 * @history:
 */
public class XN602061 extends AProcessor {
    private IGoodsAO goodsAO = SpringContextHolder.getBean(IGoodsAO.class);

    private XN602061Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Goods condition = new Goods();
        condition.setCode(req.getCode());
        condition.setModelCode(req.getModelCode());
        condition.setLogisticsCode(req.getLogisticsCode());
        condition.setUserId(req.getUserId());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IGoodsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return goodsAO.queryGoodsPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602061Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}

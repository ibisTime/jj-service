/**
 * @Title XN602041.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:19:10 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.ILogisticsAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Logistics;
import com.xnjr.mall.dto.req.XN602041Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 物流单分页查询
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:19:10 
 * @history:
 */
public class XN602041 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN602041Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Logistics condition = new Logistics();
        condition.setCode(req.getCode());
        condition.setInvoiceCode(req.getInvoiceCode());
        condition.setDeliveryDatetimeStart(DateUtil.strToDate(
            req.getDeliveryDatetimeStart(), DateUtil.DATA_TIME_PATTERN_1));
        condition.setDeliveryDatetimeEnd(DateUtil.strToDate(
            req.getDeliveryDatetimeEnd(), DateUtil.DATA_TIME_PATTERN_1));
        condition.setDeliverer(req.getDeliverer());
        condition.setUserId(req.getUserId());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ILogisticsAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return logisticsAO.queryLogisticsPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602041Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}

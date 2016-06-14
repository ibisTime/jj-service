/**
 * @Title XN602081.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:47:01 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IRepairOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.RepairOrder;
import com.xnjr.mall.dto.req.XN602081Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 维修单分页查询
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:47:01 
 * @history:
 */
public class XN602081 extends AProcessor {
    private IRepairOrderAO repairOrderAO = SpringContextHolder
        .getBean(IRepairOrderAO.class);

    private XN602081Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        RepairOrder condition = new RepairOrder();
        condition.setCodeForQuery(req.getCode());

        condition.setGoodsCodeForQuery(req.getGoodsCode());
        condition.setStatus(req.getStatus());
        condition.setUserId(req.getUserId());
        condition.setApplyUser(req.getApplyUser());
        condition.setUpdater(req.getUpdater());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IRepairOrderAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return repairOrderAO.queryRepairOrderPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602081Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }

}

/**
 * @Title XN602080.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:37:13 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IRepairOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.RepairOrder;
import com.xnjr.mall.dto.req.XN602080Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 维修单提交
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:37:13 
 * @history:
 */
public class XN602080 extends AProcessor {
    private IRepairOrderAO repairOrderAO = SpringContextHolder
        .getBean(IRepairOrderAO.class);

    private XN602080Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        RepairOrder data = new RepairOrder();
        data.setGoodsCode(req.getGoodsCode());
        data.setUserId(req.getUserId());
        data.setApplyUser(req.getApplyUser());
        data.setContact(req.getContact());
        data.setApplyReason(req.getApplyReason());
        return new PKCodeRes(repairOrderAO.addRepairOrder(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602080Req.class);
        StringValidater.validateBlank(req.getGoodsCode(), req.getUserId(),
            req.getApplyUser(), req.getApplyReason(), req.getContact());
    }

}

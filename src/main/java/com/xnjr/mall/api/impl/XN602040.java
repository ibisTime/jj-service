/**
 * @Title XN602040.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:18:27 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ILogisticsAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Logistics;
import com.xnjr.mall.dto.req.XN602040Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 物流信息录入
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:18:27 
 * @history:
 */
public class XN602040 extends AProcessor {
    private ILogisticsAO logisticsAO = SpringContextHolder
        .getBean(ILogisticsAO.class);

    private XN602040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Logistics logistics = new Logistics();
        logistics.setInvoiceCode(req.getInvoiceCode());
        logistics.setCompany(req.getCompany());
        logistics.setCode(req.getCode());
        logistics.setDeliverer(req.getDeliverer());
        logistics.setDeliveryDatetime(DateUtil.strToDate(
            req.getDeliveryDatetime(), DateUtil.DATA_TIME_PATTERN_1));
        logistics.setUpdater(req.getUpdater());
        logistics.setRemark(req.getRemark());
        return new PKCodeRes(logisticsAO.addLogistics(logistics));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602040Req.class);
        StringValidater.validateBlank(req.getInvoiceCode(), req.getUpdater());
    }

}

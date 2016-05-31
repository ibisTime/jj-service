/**
 * @Title XN602083.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:56:21 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IRepairOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602083Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 维修单处理 1-受理 0-无需处理，关闭
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:56:21 
 * @history:
 */
public class XN602083 extends AProcessor {
    private IRepairOrderAO repairOrderAO = SpringContextHolder
        .getBean(IRepairOrderAO.class);

    private XN602083Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        repairOrderAO.dealWithRepairOrder(req.getCode(), req.getCheckResult(),
            req.getCheckUser(), req.getRemark());
        return new BooleanRes(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602083Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCheckResult(),
            req.getCheckUser());
    }

}

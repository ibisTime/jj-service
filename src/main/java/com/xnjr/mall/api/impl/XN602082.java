/**
 * @Title XN602082.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:53:57 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IRepairOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602082Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 维修单详情查询
 * @author: haiqingzheng 
 * @since: 2016年5月31日 下午3:53:57 
 * @history:
 */
public class XN602082 extends AProcessor {
    private IRepairOrderAO repairOrderAO = SpringContextHolder
        .getBean(IRepairOrderAO.class);

    private XN602082Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return repairOrderAO.getRepairOrder(req.getCode());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602082Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

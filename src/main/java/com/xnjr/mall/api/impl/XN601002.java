/**
 * @Title XN601001.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月17日 上午9:06:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProductAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN601002Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 产品审核 1表示审核通过 0表示审核不通过
 * @author: haiqingzheng 
 * @since: 2016年5月17日 上午9:06:30 
 * @history:
 */
public class XN601002 extends AProcessor {

    private IProductAO productAO = SpringContextHolder
        .getBean(IProductAO.class);

    private XN601002Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        int count = productAO.checkProduct(req.getCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote());
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote());
    }

}

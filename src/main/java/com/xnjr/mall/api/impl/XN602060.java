/**
 * @Title XN602060.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午3:20:09 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGoodsAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602060Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 根据型号获取货起始编号
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午3:20:09 
 * @history:
 */
public class XN602060 extends AProcessor {
    private IGoodsAO goodsAO = SpringContextHolder.getBean(IGoodsAO.class);

    private XN602060Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(goodsAO.getGoodsCodeStart(req.getModelCode()));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602060Req.class);
        StringValidater.validateBlank(req.getModelCode());
    }

}

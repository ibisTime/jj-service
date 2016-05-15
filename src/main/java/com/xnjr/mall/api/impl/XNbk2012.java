/**
 * @Title XNbk2012.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:39:45 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKSubbranchAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNbk2012Req;
import com.xnjr.mall.dto.res.XNbk2012Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 支行审核通过
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:39:45 
 * @history:
 */
public class XNbk2012 extends AProcessor {
    private IBKSubbranchAO bkSubbranchAO = SpringContextHolder
        .getBean(IBKSubbranchAO.class);

    private XNbk2012Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        bkSubbranchAO.checkPass(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new XNbk2012Res(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2012Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater(),
            req.getRemark());
    }
}

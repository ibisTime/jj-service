/**
 * @Title XNbk2013.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:48:57 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKSubbranchAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNbk2013Req;
import com.xnjr.mall.dto.res.XNbk2013Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 审核不通过 
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:48:57 
 * @history:
 */
public class XNbk2013 extends AProcessor {
    private IBKSubbranchAO platBankAO = SpringContextHolder
        .getBean(IBKSubbranchAO.class);

    private XNbk2013Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        platBankAO
            .checkUnPass(req.getCode(), req.getUpdater(), req.getRemark());
        return new XNbk2013Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2013Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater(),
            req.getRemark());
    }
}

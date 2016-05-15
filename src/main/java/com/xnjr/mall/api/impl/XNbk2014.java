/**
 * @Title XNbk2014.java 
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
import com.xnjr.mall.dto.req.XNbk2014Req;
import com.xnjr.mall.dto.res.XNbk2014Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 审核通过，变更
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:48:57 
 * @history:
 */
public class XNbk2014 extends AProcessor {
    private IBKSubbranchAO bkSubbranchAO = SpringContextHolder
        .getBean(IBKSubbranchAO.class);

    private XNbk2014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        bkSubbranchAO.reEditBKSubbranch(req.getCode(), req.getUpdater(),
            req.getRemark());
        return new XNbk2014Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2014Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater());
    }
}

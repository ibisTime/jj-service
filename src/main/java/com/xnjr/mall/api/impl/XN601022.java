package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IModelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN601022Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 型号审核 1表示审核通过 0表示审核不通过
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:09:16 
 * @history:
 */
public class XN601022 extends AProcessor {

    private IModelAO modelAO = SpringContextHolder.getBean(IModelAO.class);

    private XN601022Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        int count = modelAO.checkModel(req.getCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote());
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601022Req.class);
        StringValidater.validateBlank(req.getCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote());
    }
}

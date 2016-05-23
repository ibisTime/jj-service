package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IModelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.dto.req.XN601026Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 详情查询型号
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:11:37 
 * @history:
 */
public class XN601026 extends AProcessor {

    private IModelAO modelAO = SpringContextHolder.getBean(IModelAO.class);

    private XN601026Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Model condition = new Model();
        condition.setCode(req.getCode());
        return modelAO.getModel(req.getCode());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601026Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

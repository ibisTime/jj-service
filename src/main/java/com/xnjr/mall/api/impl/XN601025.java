package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IModelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.dto.req.XN601025Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 列表查询型号
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:11:37 
 * @history:
 */
public class XN601025 extends AProcessor {

    private IModelAO modelAO = SpringContextHolder.getBean(IModelAO.class);

    private XN601025Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Model condition = new Model();
        condition.setCode(req.getCode());
        condition.setName(req.getName());
        condition.setProductCode(req.getProductCode());
        condition.setStatus(req.getStatus());
        return modelAO.queryModelList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601025Req.class);
    }
}

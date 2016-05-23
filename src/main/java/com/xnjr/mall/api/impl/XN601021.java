package com.xnjr.mall.api.impl;

import org.apache.commons.collections.CollectionUtils;

import com.xnjr.mall.ao.IModelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.dto.req.XN601021Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 修改型号
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN601021 extends AProcessor {

    private IModelAO modelAO = SpringContextHolder.getBean(IModelAO.class);

    private XN601021Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Model data = new Model();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setPic1(req.getPic1());
        data.setPic2(req.getPic2());
        data.setPic3(req.getPic3());
        data.setDescription(req.getDescription());
        data.setModelSpecsList(req.getModelSpecsList());
        data.setProductCode(req.getProductCode());
        data.setUpdater(req.getUpdater());
        int count = modelAO.editModel(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601021Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic1(), req.getPic2(), req.getPic3(), req.getDescription(),
            req.getProductCode(), req.getUpdater());
        if (CollectionUtils.isEmpty(req.getModelSpecsList())) {
            throw new BizException("xn702000", "必填型入参，请按要求填写完整");
        }
    }
}

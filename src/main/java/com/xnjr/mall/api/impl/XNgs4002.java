package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSStructure;
import com.xnjr.mall.dto.req.XNgs4002Req;
import com.xnjr.mall.dto.res.XNgs4001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 修改结构
 * @author: Gejin 
 * @since: 2016年4月13日 下午1:51:48 
 * @history:
 */
public class XNgs4002 extends AProcessor {

    private IGSStructureAO gsStructureAO = SpringContextHolder
        .getBean(IGSStructureAO.class);

    private XNgs4002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSStructure data = new GSStructure();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setStatus(req.getStatus());
        data.setSummary(req.getSummary());
        data.setDescription(req.getDescription());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        gsStructureAO.editStructure(data);
        return new XNgs4001Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs4002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getStatus(), req.getSummary(), req.getDescription(),
            req.getUpdater(), req.getRemark());
    }

}

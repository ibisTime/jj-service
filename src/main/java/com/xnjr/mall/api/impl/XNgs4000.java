package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GSStructure;
import com.xnjr.mall.dto.req.XNgs4000Req;
import com.xnjr.mall.dto.res.XNgs4000Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 新增结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午11:57:20 
 * @history:
 */
public class XNgs4000 extends AProcessor {

    private IGSStructureAO gsStructureAO = SpringContextHolder
        .getBean(IGSStructureAO.class);

    XNgs4000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSStructure data = new GSStructure();
        data.setName(req.getName());
        data.setStatus(req.getStatus());
        data.setSummary(req.getSummary());
        data.setDescription(req.getDescription());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNgs4000Res(gsStructureAO.addStructure(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs4000Req.class);
        StringValidater.validateBlank(req.getName(), req.getStatus(),
            req.getSummary(), req.getDescription(), req.getUpdater());
    }
}

package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IContractTemplateAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5040Req;
import com.xnjr.mall.dto.res.XNlh5040Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 合同模板-增加
 * @author: myb858 
 * @since: 2015年11月14日 下午8:54:28 
 * @history:
 */
public class XNlh5040 extends AProcessor {
    private IContractTemplateAO contractTemplateAO = SpringContextHolder
        .getBean(IContractTemplateAO.class);

    private XNlh5040Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long id = contractTemplateAO.addContractTemplate(req.getTitle(),
            req.getContent(), req.getType(), req.getStatus(), req.getUpdater(),
            req.getRemark());
        return new XNlh5040Res(id);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5040Req.class);
        StringValidater.validateBlank(req.getTitle(), req.getContent(),
            req.getType(), req.getStatus(), req.getUpdater());
    }
}

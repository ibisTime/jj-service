package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IContractTemplateAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5042Req;
import com.xnjr.mall.dto.res.XNlh5042Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 合同模板-修改
 * @author: myb858 
 * @since: 2015年11月14日 下午8:54:49 
 * @history:
 */
public class XNlh5042 extends AProcessor {
    private IContractTemplateAO contractTemplateAO = SpringContextHolder
        .getBean(IContractTemplateAO.class);

    private XNlh5042Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        contractTemplateAO.editContractTemplate(
            StringValidater.toLong(req.getId()), req.getTitle(),
            req.getContent(), req.getType(), req.getStatus(), req.getUpdater(),
            req.getRemark());
        return new XNlh5042Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5042Req.class);
        StringValidater.validateBlank(req.getId(), req.getTitle(),
            req.getContent(), req.getType(), req.getStatus(), req.getUpdater());
    }
}

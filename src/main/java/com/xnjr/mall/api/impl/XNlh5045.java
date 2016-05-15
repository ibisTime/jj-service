package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IContractTemplateAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5045Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 合同模板-详情查询
 * @author: myb858 
 * @since: 2015年11月14日 下午8:53:54 
 * @history:
 */
public class XNlh5045 extends AProcessor {
    private IContractTemplateAO contractTemplateAO = SpringContextHolder
        .getBean(IContractTemplateAO.class);

    private XNlh5045Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        // XNlh5045Res res = new XNlh5045Res();
        // ContractTemplate template =
        // contractTemplateAO.getContractTemplate(req
        // .getId());
        // if (template != null) {
        // res.setContent(template.getContent());
        // res.setStatus(template.getStatus());
        // res.setTitle(template.getTitle());
        // res.setType(template.getType());
        // }
        // return res;
        return contractTemplateAO.getContractTemplate(StringValidater
            .toLong(req.getId()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5045Req.class);
        StringValidater.validateNumber(req.getId());
    }

}

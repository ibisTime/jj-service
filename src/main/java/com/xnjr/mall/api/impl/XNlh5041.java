package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IContractTemplateAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5041Req;
import com.xnjr.mall.dto.res.XNlh5041Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 合同模板-删除
 * @author: myb858 
 * @since: 2015年11月14日 下午8:54:38 
 * @history:
 */
public class XNlh5041 extends AProcessor {
    private IContractTemplateAO contractTemplateAO = SpringContextHolder
        .getBean(IContractTemplateAO.class);

    private XNlh5041Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        contractTemplateAO.dropContractTemplate(StringValidater.toLong(req
            .getId()));
        return new XNlh5041Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5041Req.class);
        StringValidater.validateBlank(req.getId());
    }
}

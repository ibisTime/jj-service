package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs4001Req;
import com.xnjr.mall.dto.res.XNgs4002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 删除结构
 * @author: Gejin 
 * @since: 2016年4月13日 下午5:11:34 
 * @history:
 */
public class XNgs4001 extends AProcessor {

    private IGSStructureAO gsStructureAO = SpringContextHolder
        .getBean(IGSStructureAO.class);

    private XNgs4001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gsStructureAO.dropStructure(req.getCode());
        return new XNgs4002Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs4001Req.class);
        StringValidater.validateBlank(req.getCode());

    }

}

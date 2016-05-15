package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs4005Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询结构详情
 * @author: Gejin 
 * @since: 2016年4月13日 下午4:16:01 
 * @history:
 */
public class XNgs4005 extends AProcessor {
    private IGSStructureAO gsStructureAO = SpringContextHolder
        .getBean(IGSStructureAO.class);

    XNgs4005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gsStructureAO.getStructure(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs4005Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

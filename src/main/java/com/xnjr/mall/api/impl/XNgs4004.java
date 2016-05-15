package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSStructureAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.GSStructure;
import com.xnjr.mall.dto.req.XNgs4004Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 列表查询结构
 * @author: Gejin 
 * @since: 2016年4月13日 下午3:21:19 
 * @history:
 */
public class XNgs4004 extends AProcessor {
    private IGSStructureAO gsStructureAO = SpringContextHolder
        .getBean(IGSStructureAO.class);

    private XNgs4004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GSStructure data = new GSStructure();
        data.setName(req.getName());
        data.setStatus(req.getStatus());
        return gsStructureAO.queryStructureList(data);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs4004Req.class);

    }

}

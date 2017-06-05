package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IGroupAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612020Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增组
 * @author: asus 
 * @since: 2017年6月4日 下午5:05:02 
 * @history:
 */
public class XN612020 extends AProcessor {
    private IGroupAO groupAO = SpringContextHolder.getBean(IGroupAO.class);

    private XN612020Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(groupAO.addGroup(req.getName(), req.getUserId()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612020Req.class);
        StringValidater.validateBlank(req.getName(), req.getUserId());
    }

}

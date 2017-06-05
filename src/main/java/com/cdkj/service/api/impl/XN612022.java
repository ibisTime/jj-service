package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IGroupAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612022Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改组
 * @author: asus 
 * @since: 2017年6月4日 下午5:05:02 
 * @history:
 */
public class XN612022 extends AProcessor {
    private IGroupAO groupAO = SpringContextHolder.getBean(IGroupAO.class);

    private XN612022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        groupAO.editGroup(req.getCode(), req.getName());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612022Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName());
    }

}

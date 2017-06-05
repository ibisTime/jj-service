package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IGroupAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612026Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询组
 * @author: asus 
 * @since: 2017年6月4日 下午5:10:49 
 * @history:
 */
public class XN612026 extends AProcessor {
    private IGroupAO groupAO = SpringContextHolder.getBean(IGroupAO.class);

    private XN612026Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return groupAO.getGroup(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612026Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

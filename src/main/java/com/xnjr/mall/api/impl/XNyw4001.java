package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XNyw4001Req;
import com.xnjr.mall.dto.res.XNyw4001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-重新发标
 * @author: myb858 
 * @since: 2016年1月17日 下午4:19:42 
 * @history:
 */
public class XNyw4001 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private XNyw4001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        projectAO.reapplyProject(req);
        return new XNyw4001Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4001Req.class);
    }
}

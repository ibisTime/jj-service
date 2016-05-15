package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4003Req;
import com.xnjr.mall.dto.res.XNyw4003Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-强制结束标的
 * @author: myb858 
 * @since: 2016年1月17日 下午4:20:44 
 * @history:
 */
public class XNyw4003 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private XNyw4003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        projectAO.forbidProject(req.getProjectCode(), req.getCheckUser(),
            req.getCheckNote(), req.getTradePwd());
        return new XNyw4003Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4003Req.class);
        StringValidater.validateBlank(req.getProjectCode(), req.getCheckUser(),
            req.getCheckNote(), req.getTradePwd());
    }
}

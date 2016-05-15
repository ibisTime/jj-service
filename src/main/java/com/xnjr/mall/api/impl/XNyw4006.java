package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4006Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-标的详情查询
 * @author: myb858 
 * @since: 2016年1月17日 下午4:46:47 
 * @history:
 */
public class XNyw4006 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    XNyw4006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return projectAO.getProject(req.getProjectCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4006Req.class);
        StringValidater.validateBlank(req.getProjectCode());
    }
}

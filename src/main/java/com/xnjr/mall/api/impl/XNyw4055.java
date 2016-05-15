package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4055Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询项目详情
 * @author: myb858 
 * @since: 2016年1月17日 下午4:16:52 
 * @history:
 */
public class XNyw4055 extends AProcessor {
    private ISubjectAO subjectAO = SpringContextHolder
        .getBean(ISubjectAO.class);

    XNyw4055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return subjectAO.getSubject(req.getSubjectCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4055Req.class);
        StringValidater.validateBlank(req.getSubjectCode());
    }
}

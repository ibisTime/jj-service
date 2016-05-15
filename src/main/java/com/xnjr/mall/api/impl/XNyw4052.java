package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4052Req;
import com.xnjr.mall.dto.res.XNyw4052Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 结束项目
 * @author: myb858 
 * @since: 2016年1月17日 下午4:30:15 
 * @history:
 */
public class XNyw4052 extends AProcessor {
    private ISubjectAO subjectAO = SpringContextHolder
        .getBean(ISubjectAO.class);

    private XNyw4052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        subjectAO.stopSubject(req.getSubjectCode(), req.getTradePwd(),
            req.getRemark());
        return new XNyw4052Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4052Req.class);
        StringValidater.validateBlank(req.getSubjectCode(), req.getTradePwd(),
            req.getRemark());
    }
}

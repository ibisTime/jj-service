package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4050Req;
import com.xnjr.mall.dto.res.XNyw4050Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 开始项目
 * @author: myb858 
 * @since: 2016年1月17日 下午4:17:45 
 * @history:
 */
public class XNyw4050 extends AProcessor {
    private ISubjectAO subjectAO = SpringContextHolder
        .getBean(ISubjectAO.class);

    private XNyw4050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        subjectAO.startSubject(req.getSubjectCode(), req.getTradePwd(),
            req.getRemark());
        return new XNyw4050Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4050Req.class);
        StringValidater.validateBlank(req.getSubjectCode(), req.getTradePwd(),
            req.getRemark());

    }

}

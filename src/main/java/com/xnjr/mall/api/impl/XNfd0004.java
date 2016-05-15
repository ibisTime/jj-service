package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0004Req;
import com.xnjr.mall.dto.res.XNfd0004Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-三方实名认证
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:41:26 
 * @history:
 */
public class XNfd0004 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserAO.doIdentify(req.getUserId(), req.getIdKind(), req.getIdNo(),
            req.getRealName());
        return new XNfd0004Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0004Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName());

    }

}

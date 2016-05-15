package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0002Req;
import com.xnjr.mall.dto.res.XNfd0002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-登录
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:29:36 
 * @history:
 */
public class XNfd0002 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNfd0002Res(fdUserAO.doLogin(req.getLoginName(),
            req.getLoginPwd(), req.getLoginIp()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0002Req.class);
        StringValidater.validateBlank(req.getLoginName(), req.getLoginPwd(),
            req.getLoginIp());

    }

}

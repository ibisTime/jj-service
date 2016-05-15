package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0001Req;
import com.xnjr.mall.dto.res.XNfd0001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-注册
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:21:25 
 * @history:
 */
public class XNfd0001 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNfd0001Res(fdUserAO.doRegister(req.getMobile(),
            req.getSmsCaptcha(), req.getLoginPwd(), req.getRegisterIp(),
            req.getUserReferee()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0001Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getSmsCaptcha(),
            req.getLoginPwd(), req.getLoginPwdStrength(), req.getRegisterIp());

    }

}

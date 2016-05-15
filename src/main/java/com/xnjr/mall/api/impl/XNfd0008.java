package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0008Req;
import com.xnjr.mall.dto.res.XNfd0008Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户Front-找回交易密码
 * @author: Gejin 
 * @since: 2016年4月17日 下午2:28:38 
 * @history:
 */
public class XNfd0008 extends AProcessor {
    private IFDUserAO userAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0008Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNfd0008Res(userAO.doFindTradePwd(req.getUserId(),
            req.getTradePwd(), req.getTradePwdStrength(), req.getSmsCaptcha(),
            req.getIdKind(), req.getIdNo()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0008Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha(), req.getIdKind(),
            req.getIdNo());
    }
}

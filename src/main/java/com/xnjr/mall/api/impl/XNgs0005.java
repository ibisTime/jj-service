package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs0005Req;
import com.xnjr.mall.dto.res.XNgs0005Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 找回交易密码
 * @author: myb858 
 * @since: 2016年1月13日 下午1:37:36 
 * @history:
 */
public class XNgs0005 extends AProcessor {
    private IGSTraderAO gsTraderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    XNgs0005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNgs0005Res(gsTraderAO.doFindTradePwd(req.getUserId(),
            req.getTradePwd(), req.getTradePwdStrength(), req.getSmsCaptcha(),
            req.getIdKind(), req.getIdNo()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0005Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha(), req.getIdKind(),
            req.getIdNo());

    }
}

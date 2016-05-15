package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0003Req;
import com.xnjr.mall.dto.res.XNfd0003Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-实名认证并设置交易密码
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:31:03 
 * @history:
 */
public class XNfd0003 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserAO.doIdentifySetTradePwd(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
        return new XNfd0003Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0003Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getIdKind(),
            req.getIdNo(), req.getRealName(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
    }
}

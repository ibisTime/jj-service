package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0005Req;
import com.xnjr.mall.dto.res.XNfd0005Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-设置交易密码
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:45:43 
 * @history:
 */
public class XNfd0005 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserAO.doSetTradePwd(req.getUserId(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());
        return new XNfd0005Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0005Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getTradePwd(),
            req.getTradePwdStrength(), req.getSmsCaptcha());

    }

}

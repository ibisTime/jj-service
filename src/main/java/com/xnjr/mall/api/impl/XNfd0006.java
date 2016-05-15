package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0006Req;
import com.xnjr.mall.dto.res.XNfd0006Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-修改手机号
 * @author: Gejin 
 * @since: 2016年4月17日 下午2:11:12 
 * @history:
 */
public class XNfd0006 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0006Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserAO.doChangeMoblie(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha(), req.getTradePwd());
        return new XNfd0006Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0006Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getNewMobile(),
            req.getSmsCaptcha(), req.getTradePwd());

    }

}

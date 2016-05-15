package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISmsOutAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh9000Req;
import com.xnjr.mall.dto.res.XNlh9001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 发送短信验证码
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:21:25 
 * @history:
 */
public class XNlh9000 extends AProcessor {
    private ISmsOutAO smsOutAO = SpringContextHolder.getBean(ISmsOutAO.class);

    private XNlh9000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        smsOutAO.sendCaptcha(req.getMobile(), req.getBizType());
        return new XNlh9001Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh9000Req.class);
        StringValidater.validateBlank(req.getMobile(), req.getBizType());
        PhoneUtil.checkMobile(req.getMobile());// 判断格式
    }
}

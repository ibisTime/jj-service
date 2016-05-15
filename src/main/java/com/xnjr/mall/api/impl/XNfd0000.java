package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.common.PhoneUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0000Req;
import com.xnjr.mall.dto.res.XNfd0000Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户front-检查手机号是否存在
 * @author: Gejin 
 * @since: 2016年4月17日 下午1:10:56 
 * @history:
 */
public class XNfd0000 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdUserAO.doCheckMobile(req.getMobile());
        return new XNfd0000Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0000Req.class);
        StringValidater.validateBlank(req.getMobile());
        PhoneUtil.checkMobile(req.getMobile());
    }
}

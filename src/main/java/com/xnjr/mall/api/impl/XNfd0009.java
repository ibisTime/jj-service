package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0009Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户Front-获取用户信息
 * @author: Gejin 
 * @since: 2016年4月17日 下午2:42:19 
 * @history:
 */
public class XNfd0009 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0009Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdUserAO.doGetUser(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0009Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}

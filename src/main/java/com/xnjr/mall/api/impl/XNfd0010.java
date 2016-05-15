package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserLoginLogAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0010Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 用户Front-获取最新登录日志
 * @author: Gejin 
 * @since: 2016年4月17日 下午2:48:41 
 * @history:
 */
public class XNfd0010 extends AProcessor {
    private IFDUserLoginLogAO fdUserLoginLogAO = SpringContextHolder
        .getBean(IFDUserLoginLogAO.class);

    private XNfd0010Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdUserLoginLogAO.getLatestUserLoginLog(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0010Req.class);
        StringValidater.validateBlank(req.getUserId());

    }

}

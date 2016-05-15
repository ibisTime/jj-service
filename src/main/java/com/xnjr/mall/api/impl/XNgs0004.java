package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSTraderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs0004Req;
import com.xnjr.mall.dto.res.XNgs0004Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 修改交易密码
 * @author: myb858 
 * @since: 2016年1月13日 下午1:26:57 
 * @history:
 */
public class XNgs0004 extends AProcessor {
    private IGSTraderAO gsTraderAO = SpringContextHolder
        .getBean(IGSTraderAO.class);

    XNgs0004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gsTraderAO.doResetTradePwd(req.getUserId(), req.getOldTradePwd(),
            req.getNewTradePwd(), req.getNewTradePwdStrength());
        return new XNgs0004Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0004Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getOldTradePwd(),
            req.getNewTradePwd(), req.getNewTradePwdStrength());

    }

}

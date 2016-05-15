package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGSAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNgs0022Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 详细查看系统账户流水
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午5:17:46 
 * @history:
 */
public class XNgs0022 extends AProcessor {
    private IGSAJourAO gsAJourAO = SpringContextHolder
        .getBean(IGSAJourAO.class);

    private XNgs0022Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gsAJourAO.getAccountJour(req.getAccountNumber());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNgs0022Req.class);
        StringValidater.validateBlank(req.getAccountNumber());
    }

}

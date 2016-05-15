package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IRepayDetailAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4071Req;
import com.xnjr.mall.dto.res.XNyw4071Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 线下未有资金操作的，进行还款：进账（有流水）
 * @author: myb858 
 * @since: 2016年1月17日 下午5:06:47 
 * @history:
 */
public class XNyw4071 extends AProcessor {
    private IRepayDetailAO repayDetailAO = SpringContextHolder
        .getBean(IRepayDetailAO.class);

    private XNyw4071Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        repayDetailAO.repayKong(req.getRepayCode(), req.getRemark(),
            req.getTradePwd());
        return new XNyw4071Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4071Req.class);
        StringValidater.validateBlank(req.getRepayCode(), req.getRemark(),
            req.getTradePwd());
    }
}

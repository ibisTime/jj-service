package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDWithdrawAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd0053Req;
import com.xnjr.mall.dto.res.XNfd0053Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 审批线下取现订单
 * @author: duanjiewen
 * @since: 2016年4月27日 下午7:09:26 
 * @history:
 */
public class XNfd0053 extends AProcessor {
    private IFDWithdrawAO FDWithdrawAO = SpringContextHolder
        .getBean(IFDWithdrawAO.class);

    private XNfd0053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDWithdrawAO.doApproveWithdraw(req.getQxNo(), req.getApproveUser(),
            req.getApproveResult(), req.getApproveNote());
        return new XNfd0053Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0053Req.class);
        StringValidater.validateBlank(req.getQxNo(), req.getApproveUser(),
            req.getApproveResult(), req.getApproveNote());

    }

}

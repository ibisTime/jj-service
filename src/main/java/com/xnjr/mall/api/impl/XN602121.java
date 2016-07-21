package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGoodsOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602121Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 进退货申请审核
 * @author: xieyj 
 * @since: 2016年7月21日 下午2:12:25 
 * @history:
 */
public class XN602121 extends AProcessor {

    private IGoodsOrderAO goodsOrderAO = SpringContextHolder
        .getBean(IGoodsOrderAO.class);

    private XN602121Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        int count = goodsOrderAO.approveGoodsOrder(req.getCode(), req
            .getApproveUser(), req.getApproveNote(), EBoolean
            .getBooleanResultMap().get(req.getApproveResult()));
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602121Req.class);
        StringValidater.validateBlank(req.getCode(), req.getApproveUser(),
            req.getApproveResult());
    }
}

package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IGoodsOrderAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.GoodsOrder;
import com.xnjr.mall.dto.req.XN602120Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 申请进货退货(正 进/负 退)
 * @author: xieyj 
 * @since: 2016年7月21日 下午2:04:41 
 * @history:
 */
public class XN602120 extends AProcessor {

    private IGoodsOrderAO goodsOrderAO = SpringContextHolder
        .getBean(IGoodsOrderAO.class);

    private XN602120Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GoodsOrder data = new GoodsOrder();
        data.setGoodsCode(req.getGoodsCode());
        data.setPrice(req.getPrice());
        data.setQuantity(req.getQuantity());
        data.setApplyUser(req.getApplyUser());
        data.setApplyNote(req.getApplyNote());
        String code = goodsOrderAO.doApplyGoodsOrder(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602120Req.class);
        StringValidater.validateBlank(req.getGoodsCode(), req.getApplyUser(),
            req.getPrice(), req.getQuantity());
    }
}

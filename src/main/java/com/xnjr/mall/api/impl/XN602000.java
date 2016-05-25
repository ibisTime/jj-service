package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ICartAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Cart;
import com.xnjr.mall.dto.req.XN602000Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 新增购物车型号
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:04:12 
 * @history:
 */
public class XN602000 extends AProcessor {

    private ICartAO cartAO = SpringContextHolder.getBean(ICartAO.class);

    private XN602000Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Cart data = new Cart();
        data.setUserId(req.getUserId());
        data.setModelCode(req.getModelCode());
        data.setQuantity(Integer.valueOf(req.getQuantity()));
        data.setSalePrice(Long.valueOf(req.getSalePrice()));
        return new PKCodeRes(cartAO.addCart(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602000Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getModelCode());
        StringValidater.validateNumber(req.getQuantity());
        StringValidater.validateAmount(req.getSalePrice());
    }
}

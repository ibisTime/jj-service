package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBuyGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.dto.req.XN601040Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 新增购买引导
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:11:37 
 * @history:
 */
public class XN601040 extends AProcessor {

    private IBuyGuideAO buyGuideAO = SpringContextHolder
        .getBean(IBuyGuideAO.class);

    private XN601040Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BuyGuide data = new BuyGuide();
        data.setModelCode(req.getModelCode());
        data.setOriginalPrice(Long.valueOf(req.getOriginalPrice()));
        data.setDiscountPrice(Long.valueOf(req.getDiscountPrice()));
        data.setToLevel(req.getToLevel());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return buyGuideAO.addBuyGuide(data);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601040Req.class);
        StringValidater.validateBlank(req.getModelCode(), req.getToLevel(),
            req.getUpdater(), req.getRemark());
        StringValidater.validateAmount(req.getOriginalPrice(),
            req.getDiscountPrice());
    }
}

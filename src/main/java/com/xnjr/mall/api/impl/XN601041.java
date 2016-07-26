package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBuyGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.dto.req.XN601041Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 上架
 * @author: myb858 
 * @since: 2016年7月26日 下午4:38:36 
 * @history:
 */
public class XN601041 extends AProcessor {

    private IBuyGuideAO buyGuideAO = SpringContextHolder
        .getBean(IBuyGuideAO.class);

    private XN601041Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BuyGuide data = new BuyGuide();
        data.setCode(req.getCode());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        int count = buyGuideAO.offBuyGuide(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601041Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater(),
            req.getRemark());
    }
}

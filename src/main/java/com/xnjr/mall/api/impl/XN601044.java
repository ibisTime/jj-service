package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBuyGuideAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.BuyGuide;
import com.xnjr.mall.dto.req.XN601044Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 详情查询购买引导
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:11:37 
 * @history:
 */
public class XN601044 extends AProcessor {

    private IBuyGuideAO buyGuideAO = SpringContextHolder
        .getBean(IBuyGuideAO.class);

    private XN601044Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BuyGuide condition = new BuyGuide();
        condition.setCode(req.getCode());
        return buyGuideAO.queryBuyGuideList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601044Req.class);
    }
}

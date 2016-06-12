package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IMerCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN602401Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 受款账号-删除
 * @author: xieyj 
 * @since: 2016年6月11日 下午6:43:31 
 * @history:
 */
public class XN602401 extends AProcessor {
    private IMerCardAO merCardAO = SpringContextHolder
        .getBean(IMerCardAO.class);

    private XN602401Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return new BooleanRes(merCardAO.dropMerCard(req.getCode()) > 0 ? true
                : false);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602401Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

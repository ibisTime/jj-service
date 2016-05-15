package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAJourAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNlh5061Req;
import com.xnjr.mall.dto.res.XNlh5061Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-调账：通过红蓝订单调整不平账(免对账)
 * @author: xieyj 
 * @since: 2016年4月30日 下午8:17:59 
 * @history:
 */
public class XNlh5061 extends AProcessor {
    private IFDAJourAO fdAJourAO = SpringContextHolder
        .getBean(IFDAJourAO.class);

    private XNlh5061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdAJourAO.doApproveCheckJour(req.getHlNo(), req.getUpdater(),
            req.getApproveResult(), req.getRemark());
        return new XNlh5061Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNlh5061Req.class);
        StringValidater.validateBlank(req.getHlNo(), req.getUpdater(),
            req.getApproveResult(), req.getRemark());
    }
}

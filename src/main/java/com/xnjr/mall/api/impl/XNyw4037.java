package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4037Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * front-查询我的投资列表(移动端)，需排序但未排序
 * @author: xieyj 
 * @since: 2016年4月29日 上午11:31:04 
 * @history:
 */
public class XNyw4037 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    XNyw4037Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return investAO.queryMyInvestSubjectList(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4037Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}

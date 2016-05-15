package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4029Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * front-查询我的项目关联投资列表
 * @author: myb858 
 * @since: 2016年1月17日 下午4:16:06 
 * @history:
 */
public class XNyw4029 extends AProcessor {
    private IInvestAO investAO = SpringContextHolder.getBean(IInvestAO.class);

    XNyw4029Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return investAO.queryMySubjectList(req.getUserId(), req.getStatus());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4029Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getStatus());
    }
}

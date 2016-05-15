package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IRepayDetailAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4073Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询还款详情
 * @author: myb858 
 * @since: 2016年1月21日 下午7:48:10 
 * @history:
 */
public class XNyw4073 extends AProcessor {
    private IRepayDetailAO repayDetailAO = SpringContextHolder
        .getBean(IRepayDetailAO.class);

    private XNyw4073Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return repayDetailAO.getRepayDetail(req.getRepayCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4073Req.class);
        StringValidater.validateBlank(req.getRepayCode());
    }
}

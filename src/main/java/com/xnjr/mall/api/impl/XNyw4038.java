package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IInvestTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4038Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-根据项目编号，获取打款记录列表
 * @author: xieyj 
 * @since: 2016年4月29日 上午11:31:04 
 * @history:
 */
public class XNyw4038 extends AProcessor {
    private IInvestTableAO investTableAO = SpringContextHolder
        .getBean(IInvestTableAO.class);

    XNyw4038Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return investTableAO.querySubjectInvestTableList(req.getSubjectCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4038Req.class);
        StringValidater.validateBlank(req.getSubjectCode());
    }
}

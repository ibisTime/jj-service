package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XN803313Req;
import com.xnjr.mall.dto.res.XN803313Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.proxy.JsonUtil;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 预期收益计算（由于没有变动数据库，所以当做查询接口处理）:undo
 * @author: myb858 
 * @since: 2015年11月13日 下午1:44:14 
 * @history:
 */
public class XN803313 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private XN803313Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Long amount = projectAO.previewInterest(req.getProjectCode(),
            StringValidater.toLong(req.getInvestAmount()),
            DateUtil.getFrontDate(req.getInvestDate(), false));
        return new XN803313Res(amount);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN803313Req.class);
        StringValidater
            .validateBlank(req.getProjectCode(), req.getInvestDate());
        StringValidater.validateAmount(req.getInvestAmount());

    }

}

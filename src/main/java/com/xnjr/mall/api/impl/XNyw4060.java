package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4060Req;
import com.xnjr.mall.dto.res.XNyw4060Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 业务做完后，提交业务资料
 * @author: myb858 
 * @since: 2016年1月17日 下午4:30:44 
 * @history:
 */
public class XNyw4060 extends AProcessor {
    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XNyw4060Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new XNyw4060Res(businessAO.uploadBusiness(req.getName(),
            StringValidater.toLong(req.getPrincipal()),
            StringValidater.toLong(req.getProfit()), req.getHsbUrl(),
            req.getHspzUrl(), req.getFjUrl(), req.getStartDatetime(),
            req.getEndDatetime(), req.getApplyUser(), req.getRemark(),
            req.getSubjectCode(), req.getList()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4060Req.class);
        StringValidater.validateBlank(req.getName(), req.getHsbUrl(),
            req.getHspzUrl(), req.getFjUrl(), req.getStartDatetime(),
            req.getEndDatetime(), req.getApplyUser(), req.getRemark(),
            req.getSubjectCode());
        StringValidater.validateAmount(req.getPrincipal(), req.getProfit());

    }
}

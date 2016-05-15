package com.xnjr.mall.api.impl;

import java.util.List;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.dto.req.XNyw4066Req;
import com.xnjr.mall.dto.res.XNyw4066Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 项目下业务列表查询：查business表
 * @author: myb858 
 * @since: 2016年1月13日 上午11:03:28 
 * @history:
 */
public class XNyw4066 extends AProcessor {
    private ISubjectAO subjectAO = SpringContextHolder
        .getBean(ISubjectAO.class);

    private IBusinessAO businessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XNyw4066Req req;

    // 年化的不给看
    @Override
    public Object doBusiness() throws BizException {
        XNyw4066Res res = new XNyw4066Res();
        Subject subject = subjectAO.getSubject(req.getSubjectCode(),
            req.getUserId());
        res.setSubject(subject);
        List<Business> bizList = businessAO.queryFrontBusinessList(
            req.getUserId(), req.getSubjectCode());
        res.setBusinessList(bizList);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4066Req.class);
        StringValidater.validateBlank(req.getSubjectCode(), req.getUserId());
    }

}

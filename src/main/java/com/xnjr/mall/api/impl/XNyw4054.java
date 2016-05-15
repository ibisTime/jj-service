package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.dto.req.XNyw4054Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询项目列表
 * @author: myb858 
 * @since: 2016年1月17日 下午4:16:52 
 * @history:
 */
public class XNyw4054 extends AProcessor {
    private ISubjectAO subjectAO = SpringContextHolder
        .getBean(ISubjectAO.class);

    XNyw4054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Subject condition = new Subject();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setName(req.getName());
        condition.setServe(req.getServe());

        condition.setQuote(req.getQuote());
        condition.setProjectCode(req.getProjectCode());
        return subjectAO.querySubjectList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4054Req.class);
    }
}

package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4007Req;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询标的列表
 * @author: xieyj 
 * @since: 2016年4月25日 下午7:30:44 
 * @history:
 */
public class XNyw4007 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private XNyw4007Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Project condition = new Project();
        condition.setServe(req.getServeId());
        condition.setStatus(EProjectStatus.APPROVE_YES.getCode());
        return projectAO.queryProjectList(condition, req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4007Req.class);
        StringValidater.validateBlank(req.getUserId());
    }

}

package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4009Req;
import com.xnjr.mall.enums.EProjectStatus;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 可投标分页查询
 * @author: myb858 
 * @since: 2016年1月13日 上午10:50:39 
 * @history:
 */
public class XNyw4009 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private XNyw4009Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Project condition = new Project();
        condition.setStatus(EProjectStatus.APPROVE_YES.getCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = "serve";// IProjectAO.DEFAULT_ORDER_COLUMN;
            req.setOrderDir("asc");
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return projectAO.queryProjectPage(start, limit, condition,
            req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4009Req.class);
        StringValidater.validateBlank(req.getUserId());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

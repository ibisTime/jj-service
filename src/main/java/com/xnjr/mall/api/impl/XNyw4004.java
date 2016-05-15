package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Project;
import com.xnjr.mall.dto.req.XNyw4004Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-分页查询标的列表
 * @author: myb858 
 * @since: 2016年1月17日 下午4:46:17 
 * @history:
 */
public class XNyw4004 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    XNyw4004Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Project condition = new Project();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setServe(req.getServe());
        condition.setQuote(req.getQuote());
        condition.setLevel(StringValidater.toInteger(req.getLevel()));

        condition.setType(req.getType());
        condition.setTrader(req.getTrader());
        condition.setApplyUser(req.getApplyUser());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IProjectAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return projectAO.queryProjectPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4004Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

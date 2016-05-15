package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.ISubjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Subject;
import com.xnjr.mall.dto.req.XNyw4053Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询项目列表
 * @author: myb858 
 * @since: 2016年1月17日 下午4:16:52 
 * @history:
 */
public class XNyw4053 extends AProcessor {
    private ISubjectAO subjectAO = SpringContextHolder
        .getBean(ISubjectAO.class);

    XNyw4053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Subject condition = new Subject();
        condition.setCode(req.getCode());
        condition.setStatus(req.getStatus());
        condition.setName(req.getName());
        condition.setServe(req.getServe());
        condition.setQuote(req.getQuote());
        condition.setProjectCode(req.getProjectCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ISubjectAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return subjectAO.querySubjectPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4053Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}

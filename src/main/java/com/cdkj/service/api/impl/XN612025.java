package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IGroupAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Group;
import com.cdkj.service.dto.req.XN612025Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询组
 * @author: asus 
 * @since: 2017年6月4日 下午5:08:39 
 * @history:
 */
public class XN612025 extends AProcessor {
    private IGroupAO groupAO = SpringContextHolder.getBean(IGroupAO.class);

    private XN612025Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Group condition = new Group();
        condition.setUserId(req.getUserId());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IGroupAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return groupAO.queryGroupPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612025Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

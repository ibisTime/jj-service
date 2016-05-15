package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.dto.req.XNyw4063Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 分页查询业务列表
 * @author: myb858 
 * @since: 2016年1月17日 下午4:59:45 
 * @history:
 */
public class XNyw4063 extends AProcessor {
    private IBusinessAO bussinessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XNyw4063Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Business condition = new Business();
        condition.setCode(req.getCode());
        condition.setName(req.getName());
        condition.setStatus(req.getStatus());
        condition.setIsVisual(req.getIsVisual());
        condition.setApplyUser(req.getApplyUser());
        condition.setCheckUser(req.getCheckUser());
        condition.setSubjectCode(req.getSubjectCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IBusinessAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return bussinessAO.queryBusinessPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4063Req.class);
    }

}

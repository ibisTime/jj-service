package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IContractAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Contract;
import com.xnjr.mall.dto.req.XNyw4080Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 管理端合同分页查询
 * @author: myb858 
 * @since: 2016年1月17日 下午4:57:40 
 * @history:
 */
public class XNyw4080 extends AProcessor {
    private IContractAO contractAO = SpringContextHolder
        .getBean(IContractAO.class);

    private XNyw4080Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Contract condition = new Contract();
        condition.setCode(req.getCode());
        condition.setCompanyCode(req.getCompanyCode());

        condition.setSubjectCode(req.getSubjectCode());
        condition.setType(req.getType());
        condition.setStatus(req.getStatus());

        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IContractAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());

        return contractAO.queryContractPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4080Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

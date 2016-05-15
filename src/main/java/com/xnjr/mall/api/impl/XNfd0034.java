package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDAccount;
import com.xnjr.mall.dto.req.XNfd0034Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-分页查询账户
 * @author: xieyj 
 * @since: 2016年4月23日 下午5:32:03 
 * @history:
 */
public class XNfd0034 extends AProcessor {
    private IFDAccountAO fdAccountAO = SpringContextHolder
        .getBean(IFDAccountAO.class);

    private XNfd0034Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDAccount condition = new FDAccount();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setStatus(req.getStatus());
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());
        condition.setCreateDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setCreateDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFDAccountAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdAccountAO.queryAccountPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0034Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

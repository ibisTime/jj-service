package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDUserLoginLogAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserLoginLog;
import com.xnjr.mall.dto.req.XNfd0013Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-分页获取登录日志
 * @author: xieyj 
 * @since: 2016年4月23日 下午2:35:15 
 * @history:
 */
public class XNfd0013 extends AProcessor {
    private IFDUserLoginLogAO fdUserLoginLogAO = SpringContextHolder
        .getBean(IFDUserLoginLogAO.class);

    private XNfd0013Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserLoginLog condition = new FDUserLoginLog();
        condition.setUserId(req.getUserId());
        condition.setLoginIp(req.getLoginIp());
        condition.setLoginDatetimeStart(DateUtil.getFrontDate(
            req.getDateStart(), false));
        condition.setLoginDatetimeEnd(DateUtil.getFrontDate(req.getDateEnd(),
            true));
        String column = req.getOrderColumn();

        if (StringUtils.isBlank(column)) {
            column = IFDUserLoginLogAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());
        return fdUserLoginLogAO.queryUserLoginLogPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0013Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
        StringValidater.validateBlank(req.getUserId());
    }
}

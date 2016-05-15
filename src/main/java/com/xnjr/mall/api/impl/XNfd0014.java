package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDUserIdentifyAO;
import com.xnjr.mall.ao.IFDUserLoginLogAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserIdentify;
import com.xnjr.mall.dto.req.XNfd0014Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-根据UserId分页获取实名认证日志
 * @author: Gejin 
 * @since: 2016年4月17日 下午4:15:16 
 * @history:
 */
public class XNfd0014 extends AProcessor {
    private IFDUserIdentifyAO fdUserIdentifyAO = SpringContextHolder
        .getBean(IFDUserIdentifyAO.class);

    private XNfd0014Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserIdentify condition = new FDUserIdentify();
        condition.setUserId(req.getUserId());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFDUserLoginLogAO.DEFAULT_ORDER_COLUMN;
        }

        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return fdUserIdentifyAO.queryUserIdentifyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0014Req.class);
        StringValidater.validateBlank(req.getUserId());
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

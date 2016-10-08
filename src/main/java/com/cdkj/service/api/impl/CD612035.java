package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IIntentionAO;
import com.cdkj.service.ao.IServeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Intention;
import com.cdkj.service.dto.req.CD612035Req;
import com.cdkj.service.enums.EIntentionType;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 感兴趣分页查询服务
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612035 extends AProcessor {

    private IIntentionAO intiontAO = SpringContextHolder
        .getBean(IIntentionAO.class);

    private CD612035Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Intention condition = new Intention();
        condition.setFromUser(req.getFromUser());
        condition.setToCode(req.getToCode());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setType(EIntentionType.XQ.getCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IServeAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return intiontAO.queryXQIntentionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612035Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}

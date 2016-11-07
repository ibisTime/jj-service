package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IIntentionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Intention;
import com.cdkj.service.dto.req.CD612113Req;
import com.cdkj.service.enums.EIntentionType;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 分页查询申请职位或者应聘简历信息
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612113 extends AProcessor {

    private IIntentionAO intiontAO = SpringContextHolder
        .getBean(IIntentionAO.class);

    private CD612113Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Intention condition = new Intention();
        condition.setFromUser(req.getFromUser());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setType(EIntentionType.ZW.getCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IIntentionAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return intiontAO.queryZWIntentionPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612113Req.class);
        StringValidater.validateBlank(req.getStart(), req.getLimit());
    }
}

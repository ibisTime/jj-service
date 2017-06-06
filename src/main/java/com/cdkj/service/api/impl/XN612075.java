package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IGsQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.GsQualify;
import com.cdkj.service.dto.req.XN612075Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询公司资质
 * @author: asus 
 * @since: 2017年6月6日 下午5:42:18 
 * @history:
 */
public class XN612075 extends AProcessor {
    private IGsQualifyAO gsQualifyAO = SpringContextHolder
        .getBean(IGsQualifyAO.class);

    private XN612075Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        GsQualify condition = new GsQualify();
        condition.setQualifyCode(req.getQualifyCode());
        condition.setQualifyType(req.getQualifyType());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setStatus(req.getStatus());
        condition.setApplyUser(req.getApplyUser());
        condition.setApprover(req.getApproveUser());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IGsQualifyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return gsQualifyAO.queryGsQualifyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612075Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

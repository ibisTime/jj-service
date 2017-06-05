package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.domain.Qualify;
import com.cdkj.service.dto.req.XN612016Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 列表查询资质
 * @author: asus 
 * @since: 2017年6月4日 下午4:16:52 
 * @history:
 */
public class XN612016 extends AProcessor {
    private IQualifyAO qualifyAO = SpringContextHolder
        .getBean(IQualifyAO.class);

    private XN612016Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Qualify condition = new Qualify();
        condition.setType(req.getType());
        condition.setName(req.getName());
        condition.setUpdater(req.getUpdater());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IQualifyAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return qualifyAO.queryQualifyList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612016Req.class);
    }
}

package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IModelAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.dto.req.XN601027Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 根据大类，小类查询型号列表
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:11:37 
 * @history:
 */
public class XN601027 extends AProcessor {

    private IModelAO modelAO = SpringContextHolder.getBean(IModelAO.class);

    private XN601027Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Model condition = new Model();
        condition.setCategory(req.getCategory());
        condition.setType(req.getType());
        condition.setProductCode(req.getCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IModelAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return modelAO.queryModelPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN601027Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.domain.Focus;
import com.cdkj.service.dto.req.XN612036Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 列表查询关注
 * @author: asus 
 * @since: 2017年6月4日 下午5:16:18 
 * @history:
 */
public class XN612036 extends AProcessor {
    private IFocusAO focusAO = SpringContextHolder.getBean(IFocusAO.class);

    private XN612036Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Focus condition = new Focus();
        condition.setCompanyCode(req.getCompanyCode());
        condition.setUserId(req.getUserId());
        condition.setGroupCode(req.getGroupCode());
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = IFocusAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(orderColumn, req.getOrderDir());
        return focusAO.queryFocusList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612036Req.class);
    }

}

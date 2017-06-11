package com.cdkj.service.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Company;
import com.cdkj.service.dto.req.XN612061Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 列表查询公司
 * @author: asus 
 * @since: 2017年6月6日 下午2:22:43 
 * @history:
 */
public class XN612061 extends AProcessor {
    private ICompanyAO companyAO = SpringContextHolder
        .getBean(ICompanyAO.class);

    private XN612061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Company condition = new Company();
        condition.setCode(req.getCode());
        condition.setName(req.getName());
        condition.setType(req.getType());
        condition.setLocation(req.getLocation());
        condition.setProvince(req.getProvince());
        condition.setCity(req.getCity());
        condition.setArea(req.getArea());
        condition.setUserId(req.getUserId());
        condition.setGzNum(StringValidater.toInteger(req.getGzNum()));
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICompanyAO.DEFAULT_ORDER_COLUMN;
        }
        return companyAO.queryCompanyList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612061Req.class);
    }

}

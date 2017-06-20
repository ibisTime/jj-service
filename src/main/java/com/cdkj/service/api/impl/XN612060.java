package com.cdkj.service.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Company;
import com.cdkj.service.dto.req.XN612060Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 分页查询公司
 * @author: asus 
 * @since: 2017年6月6日 下午2:22:43 
 * @history:
 */
public class XN612060 extends AProcessor {
    private ICompanyAO companyAO = SpringContextHolder
        .getBean(ICompanyAO.class);

    private XN612060Req req = null;

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
        condition.setStatus(req.getStatus());
        condition.setUserId(req.getUserId());
        condition.setGzNum(StringValidater.toInteger(req.getGzNum()));
        if (StringUtils.isNotBlank(req.getQuantityCode())) {
            String[] quantityCodes = req.getQuantityCode().split(",");
            List<String> gsQuantitysList = new ArrayList<String>();
            for (int i = 0; i < quantityCodes.length; i++) {
                gsQuantitysList.add(quantityCodes[i]);
            }
            condition.setQualifyCodeList(gsQuantitysList);
        }
        String orderColumn = req.getOrderColumn();
        if (StringUtils.isBlank(orderColumn)) {
            orderColumn = ICompanyAO.DEFAULT_ORDER_COLUMN;
        }
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return companyAO.queryCompanyPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612060Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }

}

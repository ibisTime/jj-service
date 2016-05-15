package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDCompanyAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDCompanyAccount;
import com.xnjr.mall.dto.req.XNfd2043Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * oss-分页查询公司账户
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:42:43 
 * @history:
 */
public class XNfd2043 extends AProcessor {
    private IFDCompanyAccountAO fdCompanyAccountAO = SpringContextHolder
        .getBean(IFDCompanyAccountAO.class);

    private XNfd2043Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        FDCompanyAccount condition = new FDCompanyAccount();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setStatus(req.getStatus());
        condition.setCompanyCode(req.getCompanyCode());
        condition.setCompanyName(req.getCompanyName());
        String column = req.getOrderColumn();

        if (StringUtils.isBlank(column)) {
            column = IFDCompanyAccountAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = Integer.valueOf(req.getStart());
        int limit = Integer.valueOf(req.getLimit());

        return fdCompanyAccountAO.queryAccountPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2043Req.class);
        StringValidater.validateNumber(req.getStart(), req.getLimit());
    }
}

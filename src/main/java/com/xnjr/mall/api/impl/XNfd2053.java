package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.dto.req.XNfd2053Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-分页查询公司账号列表
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:04:38 
 * @history:
 */
public class XNfd2053 extends AProcessor {

    private IFDCompanyCardAO fdCompanyCardAO = SpringContextHolder
        .getBean(IFDCompanyCardAO.class);

    private XNfd2053Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDCompanyCard condition = new FDCompanyCard();
        condition.setCompanyCode(req.getCompanyCode());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return fdCompanyCardAO.queryCompanyCardPage(start, limit, condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2053Req.class);
        StringValidater.validateBlank(req.getCompanyCode());
    }
}

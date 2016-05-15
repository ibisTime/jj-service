package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.dto.req.XNfd2054Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-查询公司账号列表
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:05:02 
 * @history:
 */
public class XNfd2054 extends AProcessor {

    private IFDCompanyCardAO fdCompanyCardAO = SpringContextHolder
        .getBean(IFDCompanyCardAO.class);

    private XNfd2054Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDCompanyCard condition = new FDCompanyCard();
        condition.setCompanyCode(req.getCompanyCode());
        return fdCompanyCardAO.queryCompanyCardList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2054Req.class);
        StringValidater.validateBlank(req.getCompanyCode());
    }
}

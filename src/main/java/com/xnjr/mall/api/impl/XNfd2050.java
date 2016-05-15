package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDCompanyCard;
import com.xnjr.mall.dto.req.XNfd2050Req;
import com.xnjr.mall.dto.res.XNfd2050Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-新增公司账号
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:03:53 
 * @history:
 */
public class XNfd2050 extends AProcessor {

    private IFDCompanyCardAO fdCompanyCardAO = SpringContextHolder
        .getBean(IFDCompanyCardAO.class);

    private XNfd2050Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDCompanyCard data = new FDCompanyCard();
        data.setCompanyCode(req.getCompanyCode());
        data.setBankCode(req.getBankCode());
        data.setSubbranch(req.getSubbranch());
        data.setCardNo(req.getCardNo());
        fdCompanyCardAO.addCompanyCard(data);
        return new XNfd2050Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2050Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getBankCode(),
            req.getSubbranch(), req.getCardNo());
    }

}

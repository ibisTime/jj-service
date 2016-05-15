package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2045Req;
import com.xnjr.mall.dto.res.XNfd2030Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * front-新增公司和企业账户
 * @author: xieyj 
 * @since: 2016年4月24日 下午5:42:43 
 * @history:
 */
public class XNfd2045 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2045Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        String code = fdCompanyAO.addCompanyAndCard(req.getName(),
            req.getGsyyzzNo(), req.getIdKind(), req.getIdNo(),
            req.getRealName(), req.getCurrency(),
            StringValidater.toLong(req.getCapital()), req.getProvince(),
            req.getCity(), req.getAddress(), req.getApplyUser(),
            req.getBankCode(), req.getSubbranch(), req.getCardNo());
        return new XNfd2030Res(code);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2045Req.class);
        StringValidater.validateBlank(req.getName(), req.getGsyyzzNo(),
            req.getIdKind(), req.getIdNo(), req.getRealName(),
            req.getCurrency(), req.getCapital(), req.getProvince(),
            req.getCity(), req.getApplyUser(), req.getBankCode(),
            req.getSubbranch(), req.getCardNo());
        StringValidater.validateNumber(req.getCapital());
    }
}

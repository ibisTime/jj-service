package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IMerCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.MerCard;
import com.xnjr.mall.dto.req.XN602400Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 受款账号-新增
 * @author: xieyj 
 * @since: 2016年6月11日 下午6:39:33 
 * @history:
 */
public class XN602400 extends AProcessor {
    private IMerCardAO merCardAO = SpringContextHolder
        .getBean(IMerCardAO.class);

    private XN602400Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        MerCard data = new MerCard();
        data.setCompanyCode(req.getCompanyCode());
        data.setSubbranch(req.getSubbranch());
        data.setCardNo(req.getCardNo());
        data.setStatus(req.getStatus());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new PKCodeRes(merCardAO.addMerCard(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602400Req.class);
        StringValidater.validateBlank(req.getCompanyCode(), req.getSubbranch(),
            req.getCardNo(), req.getStatus(), req.getUpdater());
    }
}

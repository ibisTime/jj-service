package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IGsQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612073Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 审批公司资质
 * @author: asus 
 * @since: 2017年6月6日 下午5:42:18 
 * @history:
 */
public class XN612073 extends AProcessor {
    private IGsQualifyAO gsQualifyAO = SpringContextHolder
        .getBean(IGsQualifyAO.class);

    private XN612073Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        gsQualifyAO.approveGsQualify(req.getCode(), req.getApproveUser(),
            req.getApproveResult(), req.getApproveNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612073Req.class);
        StringValidater.validateBlank(req.getCode(), req.getApproveUser(),
            req.getApproveResult(), req.getApproveNote());
    }

}

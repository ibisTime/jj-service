package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IGsQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612070Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 公司申请资质
 * @author: asus 
 * @since: 2017年6月6日 下午5:42:18 
 * @history:
 */
public class XN612070 extends AProcessor {
    private IGsQualifyAO gsQualifyAO = SpringContextHolder
        .getBean(IGsQualifyAO.class);

    private XN612070Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gsQualifyAO.addGsQualify(req.getCompanyCode(),
            req.getQualifyCode(), req.getSlogan(), req.getPriceRange(),
            req.getApplyUser());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612070Req.class);
        StringValidater.validateBlank(req.getCompanyCode(),
            req.getQualifyCode(), req.getSlogan(), req.getPriceRange(),
            req.getApplyUser());
    }

}

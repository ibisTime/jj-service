package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612052Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改资质审核通过
 * @author: asus 
 * @since: 2017年6月6日 下午2:22:43 
 * @history:
 */
public class XN612052 extends AProcessor {
    private ICompanyAO companyAO = SpringContextHolder
        .getBean(ICompanyAO.class);

    private XN612052Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        companyAO.editPassCompany(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612052Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLogo(),
            req.getProvince(), req.getCity(), req.getArea(), req.getAddress(),
            req.getLongitude(), req.getLatitude(), req.getMobile(),
            req.getScale(), req.getPic(), req.getAdvPic(), req.getSlogan(),
            req.getDescription(), req.getRegisteredCapital(), req.getRegtime(),
            req.getUpdater());
    }

}

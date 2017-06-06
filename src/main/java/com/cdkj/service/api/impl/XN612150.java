package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPositionAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612150Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 发布职位
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class XN612150 extends AProcessor {

    private IPositionAO positionAO = SpringContextHolder
        .getBean(IPositionAO.class);

    private XN612150Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(positionAO.addPosition(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612150Req.class);
        StringValidater.validateBlank(req.getName(), req.getKind(),
            req.getProvince(), req.getCity(), req.getExperience(),
            req.getEducation(), req.getType(), req.getJobNum(),
            req.getMsalary(), req.getDescription(), req.getCompanyCode());
    }
}

package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IResumeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612182Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改简历
 * @author: asus 
 * @since: 2017年6月5日 下午3:09:28 
 * @history:
 */
public class XN612182 extends AProcessor {

    private IResumeAO resumeAO = SpringContextHolder.getBean(IResumeAO.class);

    private XN612182Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        resumeAO.editResume(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612182Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getIsWork(), req.getEducation(), req.getIsTz(),
            req.getStudyTime(), req.getSchool(), req.getProfession(),
            req.getType(), req.getExpPosition(), req.getExpMsalary(),
            req.getExpProvince(), req.getExpCity(), req.getWorkStatus(),
            req.getIsOpen(), req.getPublisher());
    }
}

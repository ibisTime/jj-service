package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IResumeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ResumeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.Resume;
import com.cdkj.service.dto.req.CD612061Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 发布简历
 * @author: zuixian 
 * @since: 2016年10月8日 下午1:48:29 
 * @history:
 */
public class CD612061 extends AProcessor {

    private IResumeAO resumeAO = SpringContextHolder.getBean(IResumeAO.class);

    private CD612061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        Resume data = ResumeConverter.converter(req);
        int count = resumeAO.editResume(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, CD612061Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getIsWork(), req.getEducation(), req.getIsTz(),
            req.getStudyTime(), req.getSchool(), req.getProfession(),
            req.getType(), req.getExpPosition(), req.getExpMsalary(),
            req.getExpProvince(), req.getExpCity(), req.getWorkStatus(),
            req.getIsOpen(), req.getPublisher());
    }
}

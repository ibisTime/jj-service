package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IResumeAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612183Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 简历违规处理，状态更改为违规
 * @author: zuixian 
 * @since: 2016年10月8日 下午1:48:29 
 * @history:
 */
public class XN612183 extends AProcessor {

    private IResumeAO resumeAO = SpringContextHolder.getBean(IResumeAO.class);

    private XN612183Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        resumeAO.editResumeStatus(req.getCode(), req.getDealer(),
            req.getDealNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612183Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDealer(),
            req.getDealNote());
    }
}

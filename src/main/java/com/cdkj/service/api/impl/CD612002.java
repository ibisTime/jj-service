package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeTrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeTrain;
import com.cdkj.service.dto.req.XN612090Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/** 
 * 新增培训
 * @author: zuixian 
 * @since: 2016年10月7日 下午4:06:14 
 * @history:
 */
public class CD612002 extends AProcessor {

    private IServeTrainAO serveTrainAO = SpringContextHolder
        .getBean(IServeTrainAO.class);

    private XN612090Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeTrain data = ServeConverter.converter(req);
        String code = serveTrainAO.addServeTrain(data);
        return new PKCodeRes(code);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612090Req.class);
        StringValidater.validateBlank(req.getName(), req.getCompanyCode(),
            req.getQuoteMin(), req.getQuoteMax(), req.getQualityCode(),
            req.getLectorNum(), req.getMtrainTimes(), req.getMtrainNum(),
            req.getResume1(), req.getResume2(), req.getResume3(),
            req.getCourse(), req.getPublisher());
    }
}

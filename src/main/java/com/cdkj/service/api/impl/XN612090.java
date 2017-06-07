package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612090Req;
import com.cdkj.service.dto.res.PKCodeRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 新增培训
 * @author: asus 
 * @since: 2017年6月7日 上午10:14:33 
 * @history:
 */
public class XN612090 extends AProcessor {

    private ITrainAO trainAO = SpringContextHolder.getBean(ITrainAO.class);

    private XN612090Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return new PKCodeRes(trainAO.addTrain(req));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612090Req.class);
        StringValidater.validateBlank(req.getName(), req.getPic(),
            req.getAdvPic(), req.getCompanyCode(), req.getQuoteMin(),
            req.getQuoteMax(), req.getQualityCode(), req.getLectorNum(),
            req.getMtrainTimes(), req.getMtrainNum(), req.getResume1(),
            req.getResume2(), req.getResume3(), req.getCourse(),
            req.getPublisher());
    }
}

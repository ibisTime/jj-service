package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeTrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeTrain;
import com.cdkj.service.dto.req.XN612092Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改培训
 * @author: asus 
 * @since: 2017年6月7日 上午10:14:58 
 * @history:
 */
public class XN612092 extends AProcessor {

    private IServeTrainAO serveTrainAO = SpringContextHolder
        .getBean(IServeTrainAO.class);

    private XN612092Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeTrain data = ServeConverter.converter(req);
        int count = serveTrainAO.editServeTrain(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612092Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getLectorNum(),
            req.getMtrainTimes(), req.getMtrainNum(), req.getResume1(),
            req.getResume2(), req.getResume3(), req.getCourse(),
            req.getPublisher());
    }
}

package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ITrainAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
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

    private ITrainAO trainAO = SpringContextHolder.getBean(ITrainAO.class);

    private XN612092Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        trainAO.editTrain(req);
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612092Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getPic(), req.getAdvPic(), req.getQuoteMin(),
            req.getQuoteMax(), req.getLectorNum(), req.getMtrainTimes(),
            req.getMtrainNum(), req.getResume1(), req.getResume2(),
            req.getResume3(), req.getCourse(), req.getPublisher());
        StringValidater.validateEmoji(req.getDescription());
    }
}

package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612083Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 服务违规处理，状态更改为违规
 * @author: asus 
 * @since: 2017年6月7日 上午10:22:32 
 * @history:
 */
public class XN612083 extends AProcessor {

    private IPhotoAO photoAO = SpringContextHolder.getBean(IPhotoAO.class);

    private XN612083Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        photoAO.wgclPhoto(req.getCode(), req.getDealer(), req.getDealNote());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612083Req.class);
        StringValidater.validateBlank(req.getCode(), req.getDealer(),
            req.getDealNote());
    }
}

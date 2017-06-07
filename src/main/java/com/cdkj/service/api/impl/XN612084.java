package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612084Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 拍摄服务热门设置
 * @author: asus 
 * @since: 2017年6月7日 下午3:25:54 
 * @history:
 */
public class XN612084 extends AProcessor {

    private IPhotoAO photoAO = SpringContextHolder.getBean(IPhotoAO.class);

    private XN612084Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        photoAO.editLocation(req.getCode(), req.getLocation(),
            req.getOrderNo(), req.getDealer());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612084Req.class);
        StringValidater.validateBlank(req.getCode(), req.getLocation(),
            req.getOrderNo(), req.getDealer());
    }
}

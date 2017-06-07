package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IPhotoAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612081Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 删除拍摄服务
 * @author: asus 
 * @since: 2017年6月7日 上午10:42:15 
 * @history:
 */
public class XN612081 extends AProcessor {
    private IPhotoAO photoAO = SpringContextHolder.getBean(IPhotoAO.class);

    private XN612081Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        photoAO.dropPhoto(req.getCode());
        return new BooleanRes(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612081Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

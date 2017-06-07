package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IServeCpAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.api.converter.ServeConverter;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.domain.ServeCp;
import com.cdkj.service.dto.req.XN612125Req;
import com.cdkj.service.dto.res.BooleanRes;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 修改客服外包
 * @author: asus 
 * @since: 2017年6月7日 上午10:18:35 
 * @history:
 */
public class XN612125 extends AProcessor {

    private IServeCpAO serveCpAO = SpringContextHolder
        .getBean(IServeCpAO.class);

    private XN612125Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ServeCp data = ServeConverter.converter(req);
        int count = serveCpAO.editServeCp(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612125Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getQuoteMin(), req.getQuoteMax(), req.getCkNum(),
            req.getCkArea(), req.getGoodsKind(), req.getDsendNum(),
            req.getPublisher());
    }
}

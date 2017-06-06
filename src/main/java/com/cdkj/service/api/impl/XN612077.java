package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IGsQualifyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.core.StringValidater;
import com.cdkj.service.dto.req.XN612077Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询公司资质
 * @author: asus 
 * @since: 2017年6月6日 下午5:42:18 
 * @history:
 */
public class XN612077 extends AProcessor {
    private IGsQualifyAO gsQualifyAO = SpringContextHolder
        .getBean(IGsQualifyAO.class);

    private XN612077Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return gsQualifyAO.getGsQualify(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612077Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

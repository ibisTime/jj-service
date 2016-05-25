package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IAddressAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Address;
import com.xnjr.mall.dto.req.XN602800Req;
import com.xnjr.mall.dto.res.PKCodeRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 收件地址新增
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:48:10 
 * @history:
 */
public class XN602800 extends AProcessor {
    private IAddressAO addressAO = SpringContextHolder
        .getBean(IAddressAO.class);

    private XN602800Req req = null;

    /**
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Address data = new Address();
        data.setUserId(req.getUserId());
        data.setAddressee(req.getAddressee());
        data.setMobile(req.getMobile());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setDistrict(req.getDistrict());
        data.setDetailAddress(req.getDetailAddress());
        data.setIsDefault(req.getIsDefault());
        return new PKCodeRes(addressAO.addAddress(data));
    }

    /**
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602800Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getAddressee(),
            req.getMobile(), req.getProvince(), req.getCity(),
            req.getDistrict(), req.getDetailAddress());
    }
}

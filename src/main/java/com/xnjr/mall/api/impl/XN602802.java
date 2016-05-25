package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IAddressAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Address;
import com.xnjr.mall.dto.req.XN602802Req;
import com.xnjr.mall.dto.res.BooleanRes;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 收件地址 修改
 * @author: xieyj 
 * @since: 2015年8月19日 下午7:48:10 
 * @history:
 */
public class XN602802 extends AProcessor {
    private IAddressAO addressAO = SpringContextHolder
        .getBean(IAddressAO.class);

    private XN602802Req req = null;

    /** 
     * @see com.xnjr.cpzc.service.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        Address data = new Address();
        data.setCode(req.getCode());
        data.setAddressee(req.getAddressee());
        data.setMobile(req.getMobile());
        data.setProvince(req.getProvince());
        data.setCity(req.getCity());
        data.setDistrict(req.getDistrict());
        data.setDetailAddress(req.getDetailAddress());
        data.setIsDefault(req.getIsDefault());
        int count = addressAO.editAddress(data);
        return new BooleanRes(count > 0 ? true : false);
    }

    /** 
     * @see com.xnjr.cpzc.service.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602802Req.class);
        StringValidater.validateBlank(req.getCode(), req.getAddressee(),
            req.getMobile(), req.getProvince(), req.getCity(),
            req.getDistrict(), req.getDetailAddress());
    }
}

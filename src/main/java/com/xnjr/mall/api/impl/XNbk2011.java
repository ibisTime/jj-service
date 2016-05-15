/**
 * @Title XNbk2011.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:18:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKSubbranchAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.BKSubbranch;
import com.xnjr.mall.dto.req.XNbk2011Req;
import com.xnjr.mall.dto.res.XNbk2011Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 重提支行
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:18:30 
 * @history:
 */
public class XNbk2011 extends AProcessor {
    private IBKSubbranchAO platBankAO = SpringContextHolder
        .getBean(IBKSubbranchAO.class);

    private XNbk2011Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        BKSubbranch data = new BKSubbranch();
        data.setCode(req.getCode());
        data.setName(req.getName());
        data.setBankCode(req.getBankCode());
        data.setRegion(req.getRegion());
        data.setAddress(req.getAddress());
        data.setCnapsCode(req.getCnapsCode());
        data.setSwiftCode(req.getSwiftCode());
        data.setKhjlPerson(req.getKhjlPerson());
        data.setKhjlContact(req.getKhjlContact());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        platBankAO.editBKSubbranch(data);
        return new XNbk2011Res(true);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2011Req.class);
        StringValidater.validateBlank(req.getCode(), req.getName(),
            req.getBankCode(), req.getRegion(), req.getAddress(),
            req.getCnapsCode(), req.getSwiftCode(), req.getKhjlPerson(),
            req.getKhjlContact(), req.getUpdater());
    }
}

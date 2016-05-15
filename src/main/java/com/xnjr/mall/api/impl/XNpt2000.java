/**
 * @Title XNpt2000.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午9:47:30 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompany;
import com.xnjr.mall.dto.req.XNpt2000Req;
import com.xnjr.mall.dto.res.XNpt2000Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 添加平台公司
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午9:47:30 
 * @history:
 */
public class XNpt2000 extends AProcessor {
    private IPTCompanyAO ptCompanyAO = SpringContextHolder
        .getBean(IPTCompanyAO.class);

    private XNpt2000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PTCompany data = new PTCompany();

        data.setZwName(req.getZwName());
        data.setYwName(req.getYwName());
        data.setZcAddress(req.getZcAddress());
        data.setJyAddress(req.getJyAddress());
        data.setCurrency(req.getCurrency());

        data.setCapital(req.getCapital());
        data.setFrPerson(req.getFrPerson());
        data.setGdPerson(req.getGdPerson());
        data.setCwPerson(req.getCwPerson());
        data.setDebdtxPerson(req.getDebdtxPerson());

        data.setWyRecorder(req.getWyRecorder());
        data.setWyChecker(req.getWyChecker());
        data.setTelephone(req.getTelephone());
        data.setRemark(req.getRemark());

        return new XNpt2000Res(ptCompanyAO.addPTCompany(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt2000Req.class);
        StringValidater.validateBlank(req.getZwName(), req.getYwName(),
            req.getZcAddress(), req.getJyAddress(), req.getCurrency(),

            req.getCapital(), req.getFrPerson(), req.getGdPerson(),
            req.getCwPerson(), req.getDebdtxPerson(),

            req.getWyRecorder(), req.getWyChecker(), req.getTelephone());
    }

}

/**
 * @Title XNpt0000.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:29:58 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyPersonAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyPerson;
import com.xnjr.mall.dto.req.XNpt0000Req;
import com.xnjr.mall.dto.res.XNpt0000Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 新增平台公司相关人员
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:29:58 
 * @history:
 */
public class XNpt0000 extends AProcessor {
    private IPTCompanyPersonAO ptCompanyPersonAO = SpringContextHolder
        .getBean(IPTCompanyPersonAO.class);

    private XNpt0000Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PTCompanyPerson data = new PTCompanyPerson();
        data.setRealName(req.getRealName());
        data.setIdKind(req.getIdKind());
        data.setIdNo(req.getIdNo());
        data.setIdYxq(req.getIdYxq());
        data.setMobile(req.getMobile());
        data.setTelephone(req.getTelephone());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        return new XNpt0000Res(ptCompanyPersonAO.addPTCompanyPerson(data));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt0000Req.class);
        StringValidater.validateBlank(req.getRealName(), req.getIdKind(),
            req.getIdNo(), req.getIdYxq(), req.getMobile(), req.getTelephone(),
            req.getCompanyCode());

    }
}

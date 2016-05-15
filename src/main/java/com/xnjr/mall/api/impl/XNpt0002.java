/**
 * @Title XNpt0002.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:34:44 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyPersonAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyPerson;
import com.xnjr.mall.dto.req.XNpt0002Req;
import com.xnjr.mall.dto.res.XNpt0002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 修改平台公司相关人员信息
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:34:44 
 * @history:
 */
public class XNpt0002 extends AProcessor {
    private IPTCompanyPersonAO ptCompanyPersonAO = SpringContextHolder
        .getBean(IPTCompanyPersonAO.class);

    private XNpt0002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        PTCompanyPerson data = new PTCompanyPerson();
        data.setUserId(req.getUserId());
        data.setRealName(req.getRealName());
        data.setIdKind(req.getIdKind());
        data.setIdNo(req.getIdNo());
        data.setIdYxq(req.getIdYxq());
        data.setMobile(req.getMobile());
        data.setTelephone(req.getTelephone());
        data.setRemark(req.getRemark());
        data.setCompanyCode(req.getCompanyCode());
        ptCompanyPersonAO.editPTCompanyPerson(data);
        return new XNpt0002Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt0002Req.class);
        StringValidater.validateBlank(req.getUserId(), req.getRealName(),
            req.getIdKind(), req.getIdNo(), req.getIdYxq(), req.getMobile(),
            req.getTelephone(), req.getCompanyCode());
    }
}

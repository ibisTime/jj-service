/**
 * @Title XNpt0001.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:37:46 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyPersonAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNpt0001Req;
import com.xnjr.mall.dto.res.XNpt0001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 删除平台公司相关人员
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:37:46 
 * @history:
 */
public class XNpt0001 extends AProcessor {
    private IPTCompanyPersonAO ptCompanyPersonAO = SpringContextHolder
        .getBean(IPTCompanyPersonAO.class);

    private XNpt0001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ptCompanyPersonAO.dropPTCompanyPerson(req.getUserId());
        return new XNpt0001Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt0001Req.class);
        StringValidater.validateBlank(req.getUserId());
    }

}

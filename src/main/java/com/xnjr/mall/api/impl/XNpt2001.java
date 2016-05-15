/**
 * @Title XN803544.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:03:02 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNpt2001Req;
import com.xnjr.mall.dto.res.XNpt2001Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 删除平台公司
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:03:02 
 * @history:
 */
public class XNpt2001 extends AProcessor {
    private IPTCompanyAO ptCompanyAO = SpringContextHolder
        .getBean(IPTCompanyAO.class);

    private XNpt2001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        ptCompanyAO.dropPTCompany(req.getCode());
        return new XNpt2001Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt2001Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

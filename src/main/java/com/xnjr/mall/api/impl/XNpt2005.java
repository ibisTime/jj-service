/**
 * @Title XNpt2005.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月4日 下午10:06:47 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNpt2005Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 根据code获取平台公司详情
 * @author: haiqingzheng 
 * @since: 2016年3月4日 下午10:06:47 
 * @history:
 */
public class XNpt2005 extends AProcessor {
    private IPTCompanyAO ptCompanyAO = SpringContextHolder
        .getBean(IPTCompanyAO.class);

    private XNpt2005Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return ptCompanyAO.getPTCompany(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNpt2005Req.class);
        StringValidater.validateBlank(req.getCode());
    }
}

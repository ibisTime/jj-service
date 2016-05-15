package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XNyw4064Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询业务列表(未实现)
 * @author: myb858 
 * @since: 2016年1月17日 下午4:59:45 
 * @history:
 */
public class XNyw4064 extends AProcessor {
    private IBusinessAO bussinessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private XNyw4064Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4064Req.class);
    }

}

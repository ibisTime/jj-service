package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2056Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 查询公司和个人银行卡列表
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:05:15 
 * @history:
 */
public class XNfd2056 extends AProcessor {

    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd2056Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdUserAO.queryMyBankCardNoList(req.getUserId());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2056Req.class);
        StringValidater.validateBlank(req.getUserId());
    }
}

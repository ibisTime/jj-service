package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2055Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-查询公司账号详情
 * @author: xieyj 
 * @since: 2016年4月22日 上午7:05:15 
 * @history:
 */
public class XNfd2055 extends AProcessor {

    private IFDCompanyCardAO fdCompanyCardAO = SpringContextHolder
        .getBean(IFDCompanyCardAO.class);

    private XNfd2055Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return fdCompanyCardAO.getCompanyCard(StringValidater.toLong(req
            .getId()));
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2055Req.class);
        StringValidater.validateBlank(req.getId());
    }
}

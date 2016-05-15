package com.xnjr.mall.api.impl;

import java.util.List;

import com.xnjr.mall.ao.IBusinessAO;
import com.xnjr.mall.ao.IBusinessTableAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.BusinessTable;
import com.xnjr.mall.dto.req.XNyw4065Req;
import com.xnjr.mall.dto.res.XNyw4065Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 业务详情查询（核算表一起拉出来）
 * @author: myb858 
 * @since: 2016年1月17日 下午5:00:18 
 * @history:
 */
public class XNyw4065 extends AProcessor {
    private IBusinessAO bussinessAO = SpringContextHolder
        .getBean(IBusinessAO.class);

    private IBusinessTableAO businessTableAO = SpringContextHolder
        .getBean(IBusinessTableAO.class);

    private XNyw4065Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        String businessCode = req.getBusinessCode();
        XNyw4065Res res = new XNyw4065Res();
        Business biz = bussinessAO.getBusiness(businessCode);
        res.setBusiness(biz);
        List<BusinessTable> businessTableList = businessTableAO
            .queryBusinessTableList(businessCode);
        res.setBusinessTableList(businessTableList);
        return res;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4065Req.class);
        StringValidater.validateBlank(req.getBusinessCode());
    }

}

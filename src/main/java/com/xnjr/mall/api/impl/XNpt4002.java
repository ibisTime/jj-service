package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4002Req;
import com.xnjr.mall.dto.res.XNpt4002Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 审核通过平台账户
 * @author: xieyj 
 * @since: 2016年3月6日 上午9:20:26 
 * @history:
 */
public class XNpt4002 extends AProcessor {

    private IPTCompanyCardAO ptCompanyCardAO = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4002Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard data = new PTCompanyCard();
        data.setCode(req.getCode());
        data.setUpdater(req.getUpdater());
        data.setRemark(req.getRemark());
        return new XNpt4002Res(ptCompanyCardAO.passPTCompanyCard(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XNpt4002Req.class);
        StringValidater.validateBlank(req.getCode(), req.getUpdater(),
            req.getRemark());
    }
}

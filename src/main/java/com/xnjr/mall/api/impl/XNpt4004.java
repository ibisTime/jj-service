package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IPTCompanyCardAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.PTCompanyCard;
import com.xnjr.mall.dto.req.XNpt4004Req;
import com.xnjr.mall.dto.res.XNpt4004Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.http.JsonUtils;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 设置受款标志
 * @author: haiqingzheng 
 * @since: 2016年4月15日 下午2:19:43 
 * @history:
 */
public class XNpt4004 extends AProcessor {

    private IPTCompanyCardAO ptCompanyCardAO = SpringContextHolder
        .getBean(IPTCompanyCardAO.class);

    private XNpt4004Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        PTCompanyCard data = new PTCompanyCard();
        data.setCode(req.getCode());
        data.setIsAccept(req.getIsAccept());
        data.setUpdater(req.getUpdater());
        return new XNpt4004Res(ptCompanyCardAO.editIsAcceptPTCompanyCard(data));
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtils.json2Bean(inputparams, XNpt4004Req.class);
        StringValidater.validateBlank(req.getCode(), req.getIsAccept());
    }
}

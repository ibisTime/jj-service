package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDCompanyAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNfd2031Req;
import com.xnjr.mall.dto.res.XNfd2031Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 资金方-企业资料补充（修改）
 * @author: xieyj 
 * @since: 2016年4月21日 下午8:48:27 
 * @history:
 */
public class XNfd2031 extends AProcessor {
    private IFDCompanyAO fdCompanyAO = SpringContextHolder
        .getBean(IFDCompanyAO.class);

    private XNfd2031Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        fdCompanyAO.editPicture(req.getCode(), req.getGsyyzzPicture(),
            req.getZzjgdmzPicture(), req.getSwdjzPicture(),
            req.getDzzPicture(), req.getFrPicture(), req.getOtherPicture());
        return new XNfd2031Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2031Req.class);
        StringValidater.validateBlank(req.getCode());
        StringValidater.validateBlank(req.getCode(), req.getGsyyzzPicture(),
            req.getZzjgdmzPicture(), req.getSwdjzPicture(),
            req.getDzzPicture(), req.getFrPicture());
    }
}

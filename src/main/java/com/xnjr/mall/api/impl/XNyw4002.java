package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IProjectAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4002Req;
import com.xnjr.mall.dto.res.XNyw4002Res;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-审核标的
 * @author: myb858 
 * @since: 2016年1月17日 下午4:20:07 
 * @history:
 */
public class XNyw4002 extends AProcessor {
    private IProjectAO projectAO = SpringContextHolder
        .getBean(IProjectAO.class);

    private XNyw4002Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        projectAO.checkProject(req.getProjectCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote(), req.getTradePwd(),
            StringValidater.toLong(req.getPeriod()), req.getRepayDatetime());
        return new XNyw4002Res(true);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4002Req.class);
        StringValidater.validateBlank(req.getProjectCode(), req.getCheckUser(),
            req.getCheckResult(), req.getCheckNote(), req.getTradePwd());
        if (EBoolean.YES.getCode().equalsIgnoreCase(req.getCheckResult())) { // 审批通过
            StringValidater.validateBlank(req.getPeriod(),
                req.getRepayDatetime());
        }
    }
}

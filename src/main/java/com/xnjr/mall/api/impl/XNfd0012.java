package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDUserAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.FDUser;
import com.xnjr.mall.dto.req.XNfd0012Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * oss-查询用户列表
 * @author: xieyj 
 * @since: 2016年4月23日 下午2:51:49 
 * @history:
 */
public class XNfd0012 extends AProcessor {
    private IFDUserAO fdUserAO = SpringContextHolder.getBean(IFDUserAO.class);

    private XNfd0012Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUser condition = new FDUser();
        condition.setMobile(req.getMobile());
        condition.setUserKind(req.getUserKind());
        condition.setUserReferee(req.getUserReferee());
        condition.setIdKind(req.getIdKind());

        condition.setIdNo(req.getIdNo());
        condition.setRealName(req.getRealName());
        condition.setStatus(req.getStatus());
        return fdUserAO.queryUserList(condition);
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd0012Req.class);
    }
}

package com.cdkj.service.api.impl;

import com.cdkj.service.ao.IFocusAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.common.JsonUtil;
import com.cdkj.service.dto.req.XN612037Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 详情查询关注
 * @author: asus 
 * @since: 2017年6月4日 下午5:20:09 
 * @history:
 */
public class XN612037 extends AProcessor {
    private IFocusAO focusAO = SpringContextHolder.getBean(IFocusAO.class);

    private XN612037Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        return focusAO.getFocus(req.getCode());
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN612037Req.class);
    }
}

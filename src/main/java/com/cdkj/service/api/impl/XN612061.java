package com.cdkj.service.api.impl;

import com.cdkj.service.ao.ICompanyAO;
import com.cdkj.service.api.AProcessor;
import com.cdkj.service.dto.req.XN612061Req;
import com.cdkj.service.exception.BizException;
import com.cdkj.service.exception.ParaException;
import com.cdkj.service.spring.SpringContextHolder;

/**
 * 列表查询公司
 * @author: asus 
 * @since: 2017年6月6日 下午2:22:43 
 * @history:
 */
public class XN612061 extends AProcessor {
    private ICompanyAO companyAO = SpringContextHolder
        .getBean(ICompanyAO.class);

    private XN612061Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void doCheck(String inputparams) throws ParaException {
        // TODO Auto-generated method stub

    }

}

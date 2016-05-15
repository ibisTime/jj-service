/**
 * @Title XNyw4900.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月30日 下午5:02:36 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDAccountAO;
import com.xnjr.mall.ao.IRepayDetailAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNyw4900Req;
import com.xnjr.mall.dto.res.XNyw4900Res;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 统计用户本金和累计收益
 * @author: haiqingzheng 
 * @since: 2016年4月30日 下午5:02:36 
 * @history:
 */
public class XNyw4900 extends AProcessor {
    private IRepayDetailAO repayDetailAO = SpringContextHolder
        .getBean(IRepayDetailAO.class);

    private IFDAccountAO fdAccountAO = SpringContextHolder
        .getBean(IFDAccountAO.class);

    private XNyw4900Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {

        XNyw4900Res res = new XNyw4900Res();
        res.setTotalPrincipal(fdAccountAO.getTotalPrincipal(req.getUserId()));
        res.setTotalInvest(repayDetailAO.getTotalInvest(req.getUserId()));
        res.setTotalProfit(repayDetailAO.getTotalProfit(req.getUserId()));
        return res;
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNyw4900Req.class);
        StringValidater.validateBlank(req.getUserId());
    }

}

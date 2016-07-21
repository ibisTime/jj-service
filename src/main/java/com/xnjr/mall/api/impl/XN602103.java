/**
 * @Title XN602081.java 
 * @Package com.xnjr.mall.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月31日 下午3:47:01 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IIntegralAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.dto.req.XN602103Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/**
 * 积分块详情查询
 * @author: xieyj 
 * @since: 2016年7月21日 上午11:16:32 
 * @history:
 */
public class XN602103 extends AProcessor {
    private IIntegralAO integralAO = SpringContextHolder
        .getBean(IIntegralAO.class);

    private XN602103Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return integralAO.getIntegral(req.getCode());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XN602103Req.class);
    }
}

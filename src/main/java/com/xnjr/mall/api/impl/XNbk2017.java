/**
 * @Title XNbk2017.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年3月5日 下午4:58:18 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IBKSubbranchAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.dto.req.XNbk2017Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 根据银行编码查询银行信息
 * @author: haiqingzheng 
 * @since: 2016年3月5日 下午4:58:18 
 * @history:
 */
public class XNbk2017 extends AProcessor {
    private IBKSubbranchAO bkSubbranchAO = SpringContextHolder
        .getBean(IBKSubbranchAO.class);

    private XNbk2017Req req = null;

    /** 
     * @see com.xnjr.mall.api.IProcessor#doBusiness()
     */
    @Override
    public Object doBusiness() throws BizException {
        return bkSubbranchAO.getBKSubbranch(req.getCode());
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNbk2017Req.class);
        StringValidater.validateBlank(req.getCode());
    }

}

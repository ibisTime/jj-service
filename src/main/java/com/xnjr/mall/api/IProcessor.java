/**
 * @Title IProcessor.java 
 * @Package com.hsnet.pz.api.service 
 * @Description 
 * @author miyb  
 * @date 2015-3-23 上午11:04:56 
 * @version V1.0   
 */
package com.xnjr.mall.api;

import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;

/** 
 * @author: miyb 
 * @since: 2015-3-23 上午11:04:56 
 * @history:
 */
public interface IProcessor {
    /**
     * 统一入口
     * @param inputparams
     * @return
     * @throws BizException
     * @throws ParaException 
     * @create: 2015-5-6 上午9:05:41 miyb
     * @history:
     */
    public Object doProcessor(String inputparams) throws BizException,
            ParaException;

    /**
     * 统一业务处理
     * @return
     * @throws BizException 
     * @create: 2015-5-6 上午9:05:14 miyb
     * @history:
     */

    public Object doBusiness() throws BizException;

    /**
     * 统一参数校验
     * @param inputparams
     * @throws ParaException 
     * @create: 2015-5-6 上午9:05:26 miyb
     * @history:
     */
    public void doCheck(String inputparams) throws ParaException;

}

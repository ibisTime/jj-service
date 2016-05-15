/**
 * @Title XNfd2000.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午8:57:53 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import com.xnjr.mall.ao.IFDIndividualAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.domain.FDIndividual;
import com.xnjr.mall.dto.req.XNfd2003Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 查询个体户列表
 * @author: xieyj 
 * @since: 2016年4月22日 下午8:57:53 
 * @history:
 */
public class XNfd2003 extends AProcessor {
    private IFDIndividualAO fdIndividualAO = SpringContextHolder
        .getBean(IFDIndividualAO.class);

    private XNfd2003Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDIndividual condition = new FDIndividual();
        condition.setName(req.getName());
        return fdIndividualAO.queryIndividualList(condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2003Req.class);
    }
}

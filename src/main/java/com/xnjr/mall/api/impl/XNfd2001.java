/**
 * @Title XNfd2000.java 
 * @Package com.xnjr.moom.api.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午8:57:53 
 * @version V1.0   
 */
package com.xnjr.mall.api.impl;

import org.apache.commons.lang3.StringUtils;

import com.xnjr.mall.ao.IFDUserAccountAO;
import com.xnjr.mall.api.AProcessor;
import com.xnjr.mall.common.JsonUtil;
import com.xnjr.mall.core.StringValidater;
import com.xnjr.mall.domain.FDUserAccount;
import com.xnjr.mall.dto.req.XNfd2001Req;
import com.xnjr.mall.exception.BizException;
import com.xnjr.mall.exception.ParaException;
import com.xnjr.mall.spring.SpringContextHolder;

/** 
 * 分页查询个体户账户
 * @author: xieyj 
 * @since: 2016年4月22日 下午8:57:53 
 * @history:
 */
public class XNfd2001 extends AProcessor {
    private IFDUserAccountAO fdUserAccountAO = SpringContextHolder
        .getBean(IFDUserAccountAO.class);

    private XNfd2001Req req = null;

    @Override
    public Object doBusiness() throws BizException {
        FDUserAccount condition = new FDUserAccount();
        condition.setAccountNumber(req.getAccountNumber());
        condition.setUserId(req.getUserId());
        condition.setRealName(req.getRealName());
        condition.setStatus(req.getStatus());
        String column = req.getOrderColumn();
        if (StringUtils.isBlank(column)) {
            column = IFDUserAccountAO.DEFAULT_ORDER_COLUMN;
        }
        condition.setOrder(column, req.getOrderDir());
        int start = StringValidater.toInteger(req.getStart());
        int limit = StringValidater.toInteger(req.getLimit());
        return fdUserAccountAO.queryUserAccountPage(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.api.IProcessor#doCheck(java.lang.String)
     */
    @Override
    public void doCheck(String inputparams) throws ParaException {
        req = JsonUtil.json2Bean(inputparams, XNfd2001Req.class);
    }
}

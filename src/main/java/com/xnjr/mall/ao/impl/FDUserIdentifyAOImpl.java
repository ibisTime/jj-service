package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDUserIdentifyAO;
import com.xnjr.mall.bo.IFDUserIdentifyBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserIdentify;

/** 
 * 实名认证
 * @author: xieyj 
 * @since: 2016年4月23日 下午1:43:09 
 * @history:
 */
@Service
public class FDUserIdentifyAOImpl implements IFDUserIdentifyAO {

    @Autowired
    private IFDUserIdentifyBO fdUserIdentifyBO;

    /** 
     * @see com.xnjr.mall.ao.IFDUserLoginLogAO#queryUserLoginLogPage(java.lang.String)
     */
    @Override
    public Paginable<FDUserIdentify> queryUserIdentifyPage(int start,
            int limit, FDUserIdentify condition) {
        return fdUserIdentifyBO.getPaginable(start, limit, condition);
    }
}

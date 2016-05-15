/**
 * @Title FDUserLoginLogAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月23日 下午1:43:09 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDUserLoginLogAO;
import com.xnjr.mall.bo.IFDUserLoginLogBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDUserLoginLog;

/** 
 * @author: xieyj 
 * @since: 2016年4月23日 下午1:43:09 
 * @history:
 */
@Service
public class FDUserLoginLogAOImpl implements IFDUserLoginLogAO {

    @Autowired
    private IFDUserLoginLogBO fdUserLoginLogBO;

    /** 
     * @see com.xnjr.mall.ao.IFDUserLoginLogAO#getLatestUserLoginLog(java.lang.String)
     */
    @Override
    public FDUserLoginLog getLatestUserLoginLog(String userId) {
        return fdUserLoginLogBO.getLatestUserLoginLog(userId);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserLoginLogAO#queryUserLoginLogPage(java.lang.String)
     */
    @Override
    public Paginable<FDUserLoginLog> queryUserLoginLogPage(int start,
            int limit, FDUserLoginLog condition) {
        return fdUserLoginLogBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IFDUserLoginLogAO#queryUserLoginLogList(java.lang.String)
     */
    @Override
    public List<FDUserLoginLog> queryUserLoginLogList(FDUserLoginLog condition) {
        return fdUserLoginLogBO.queryUserLoginLogList(condition);
    }
}

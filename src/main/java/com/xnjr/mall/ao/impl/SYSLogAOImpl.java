/**
 * @Title SYSLogAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午9:43:16 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.ISYSLogAO;
import com.xnjr.mall.bo.ISYSLogBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SYSLog;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午9:43:16 
 * @history:
 */
@Service
public class SYSLogAOImpl implements ISYSLogAO {
    @Autowired
    ISYSLogBO sysLogBO;

    /** 
     * @see com.xnjr.mall.ao.ISYSLogAO#querySYSLogPage(int, int, com.xnjr.mall.domain.SYSLog)
     */
    @Override
    public Paginable<SYSLog> querySYSLogPage(int start, int limit,
            SYSLog condition) {
        return sysLogBO.getPaginable(start, limit, condition);
    }

}

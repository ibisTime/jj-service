/**
 * @Title ISYSLogAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午9:41:29 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.SYSLog;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午9:41:29 
 * @history:
 */
public interface ISYSLogAO {

    static String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 分页查询操作日志
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2016年4月16日 下午9:42:34 haiqingzheng
     * @history:
     */
    public Paginable<SYSLog> querySYSLogPage(int start, int limit,
            SYSLog condition);
}

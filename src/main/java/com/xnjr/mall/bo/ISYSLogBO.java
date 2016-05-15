/**
 * @Title ISYSLogBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年4月16日 下午9:34:50 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.Date;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.SYSLog;

/** 
 * @author: haiqingzheng 
 * @since: 2016年4月16日 下午9:34:50 
 * @history:
 */
public interface ISYSLogBO extends IPaginableBO<SYSLog> {
    /**
     * 增加新增日志
     * @param toTable
     * @param toRow
     * @param operater
     * @param operateDatetime
     * @return 
     * @create: 2016年4月22日 上午11:58:30 myb858
     * @history:
     */
    public String saveInsertLog(String toTable, String toRow, String operater,
            Date operateDatetime);

    /**
     * 增加删除日志
     * @param toTable
     * @param toRow
     * @param operater
     * @param operateDatetime
     * @return 
     * @create: 2016年4月22日 上午11:58:21 myb858
     * @history:
     */
    public String saveDeleteLog(String toTable, String toRow, String operater,
            Date operateDatetime);

    /**
     * 增加修改日志
     * @param toTable
     * @param toRow
     * @param toColumn
     * @param preValue
     * @param postValue
     * @param operater
     * @param operateDatetime
     * @return 
     * @create: 2016年4月22日 上午11:58:13 myb858
     * @history:
     */
    public String saveUpdateLog(String toTable, String toRow, String toColumn,
            String preValue, String postValue, String operater,
            Date operateDatetime);

    /**
     * 增加修改日志
     * @param toTable
     * @param toRow
     * @param operater
     * @param operateDatetime
     * @return 
     * @create: 2016年4月22日 下午2:25:35 myb858
     * @history:
     */
    public String saveUpdateLog(String toTable, String toRow, String operater,
            Date operateDatetime);

    /**
     * 增加登录日志
     * @param toTable
     * @param toRow
     * @param operater
     * @param operateDatetime
     * @return 
     * @create: 2016年4月22日 上午11:58:05 myb858
     * @history:
     */
    public String saveLoginLog(String toTable, String toRow, String operater,
            Date operateDatetime);
}

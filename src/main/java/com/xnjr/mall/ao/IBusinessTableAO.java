package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.domain.BusinessTable;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: wuql
 * @since: 2016年1月19日 上午11:34:10 
 * @history:
 */
@ServiceModule
public interface IBusinessTableAO {

    /**
     * 业务详情（核算表）查询
     * @param businessCode
     * @return 
     * @create: 2016年1月19日 下午5:46:56 wuql
     * @history:
     */
    public List<BusinessTable> queryBusinessTableList(String businessCode);
}

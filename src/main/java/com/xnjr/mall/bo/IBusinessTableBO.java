/**
 * @Title IBusinessTableBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月17日 下午3:28:53 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.BusinessTable;

/** 
 * @author: wuql
 * @since: 2016年1月19日 下午5:32:32 
 * @history:
 */
public interface IBusinessTableBO extends IPaginableBO<BusinessTable> {
    public void saveBusinessTable(BusinessTable data);

    public void removeBusinessTable(String businessCode);

    public List<BusinessTable> queryBusinessTableList(String businessCode);

}

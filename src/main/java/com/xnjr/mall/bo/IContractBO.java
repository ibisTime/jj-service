/**
 * @Title IContractBO.java 
 * @Package com.xnjr.pop.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月14日 下午3:37:17 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Business;
import com.xnjr.mall.domain.Contract;
import com.xnjr.mall.domain.ContractTemplate;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月14日 下午3:37:17 
 * @history:
 */
public interface IContractBO extends IPaginableBO<Contract> {

    /**
     * 
     * @param project
     * @param business
     * @param template
     * @return 
     * @create: 2016年5月4日 上午10:21:58 haiqingzheng
     * @history:
     */
    String generateBusiness(Business business, ContractTemplate template);

    /**
     * 根据合同编号获取合同
     * @param code
     * @return 
     * @create: 2016年5月4日 上午10:14:57 haiqingzheng
     * @history:
     */
    Contract getContract(String code);
}

/**
 * @Title IContractTemplateBO.java 
 * @Package com.xnjr.pop.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月14日 下午6:55:14 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.ContractTemplate;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月14日 下午6:55:14 
 * @history:
 */
public interface IContractTemplateBO extends IPaginableBO<ContractTemplate> {

    public boolean isContractTemplateExist(Long id);

    public int saveContractTemplate(ContractTemplate data);

    public int removeContractTemplate(Long id);

    public int refreshContractTemplate(ContractTemplate data);

    public ContractTemplate getContractTemplateByTitle(String title);

    public ContractTemplate getContractTemplate(Long id);

    public List<ContractTemplate> queryContractTemplateList(
            ContractTemplate condition);

}

/**
 * @Title ContractTemplateBOImpl.java 
 * @Package com.xnjr.pop.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月14日 下午6:56:09 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IContractTemplateBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IContractTemplateDAO;
import com.xnjr.mall.domain.ContractTemplate;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月14日 下午6:56:09 
 * @history:
 */
@Component
public class ContractTemplateBOImpl extends PaginableBOImpl<ContractTemplate>
        implements IContractTemplateBO {
    @Autowired
    IContractTemplateDAO contractTemplateDAO;

    /**
     * @see com.xnjr.pop.bo.IContractTemplateBO#getContractTemplate(java.lang.String)
     */
    @Override
    public ContractTemplate getContractTemplate(Long id) {
        ContractTemplate contractTemplate = null;
        if (id > 0) {
            ContractTemplate condition = new ContractTemplate();
            condition.setId(id);
            contractTemplate = contractTemplateDAO.select(condition);
        }
        return contractTemplate;
    }

    @Override
    public ContractTemplate getContractTemplateByTitle(String title) {
        ContractTemplate contractTemplate = null;
        if (StringUtils.isNotBlank(title)) {
            ContractTemplate condition = new ContractTemplate();
            condition.setTitle(title);
            List<ContractTemplate> list = contractTemplateDAO
                .selectList(condition);
            if (CollectionUtils.isNotEmpty(list)) {
                contractTemplate = list.get(0);
            }
        }
        return contractTemplate;
    }

    @Override
    public boolean isContractTemplateExist(Long id) {
        ContractTemplate advise = new ContractTemplate();
        advise.setId(id);
        if (contractTemplateDAO.selectTotalCount(advise) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public int saveContractTemplate(ContractTemplate data) {
        int count = 0;
        if (data != null) {
            data.setUpdateDatetime(new Date());
            count = contractTemplateDAO.insert(data);
        }
        return count;
    }

    @Override
    public int removeContractTemplate(Long id) {
        int count = 0;
        if (id != null) {
            ContractTemplate data = new ContractTemplate();
            data.setId(id);
            count = contractTemplateDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshContractTemplate(ContractTemplate data) {
        int count = 0;
        if (data.getId() != null) {
            data.setUpdateDatetime(new Date());
            count = contractTemplateDAO.update(data);
        }
        return count;
    }

    @Override
    public List<ContractTemplate> queryContractTemplateList(
            ContractTemplate condition) {
        return contractTemplateDAO.selectList(condition);
    }

}

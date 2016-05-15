package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IContractTemplateAO;
import com.xnjr.mall.bo.IContractTemplateBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.ContractTemplate;
import com.xnjr.mall.exception.BizException;

@Service
public class ContractTemplateAOImpl implements IContractTemplateAO {
    @Autowired
    IContractTemplateBO contractTemplateBO;

    @Override
    public List<ContractTemplate> queryContractTemplateList(
            ContractTemplate condition) {
        return contractTemplateBO.queryContractTemplateList(condition);
    }

    @Override
    public Paginable<ContractTemplate> queryContractTemplatePage(int start,
            int limit, ContractTemplate condition) {
        return contractTemplateBO.getPaginable(start, limit, condition);
    }

    @Override
    public ContractTemplate getContractTemplate(Long id) {
        ContractTemplate data = null;
        if (id > 0) {
            data = contractTemplateBO.getContractTemplate(id);
        }
        return data;
    }

    @Override
    public Long addContractTemplate(String title, String content, String type,
            String status, String updater, String remark) {
        ContractTemplate dbData = contractTemplateBO
            .getContractTemplateByTitle(title);
        if (dbData != null) {
            throw new BizException("ZC000001", "合同标题已经存在");
        }
        ContractTemplate data = new ContractTemplate();
        data.setTitle(title);
        data.setContent(content);
        data.setType(type);
        data.setStatus(status);
        data.setUpdater(updater);
        data.setRemark(remark);
        contractTemplateBO.saveContractTemplate(data);
        return data.getId();
    }

    @Override
    public void dropContractTemplate(Long id) {
        if (id > 0) {
            if (!contractTemplateBO.isContractTemplateExist(id)) {
                throw new BizException("ZC000001", "序号不存在");
            }
            contractTemplateBO.removeContractTemplate(id);
        }
    }

    @Override
    public void editContractTemplate(Long id, String title, String content,
            String type, String status, String updater, String remark) {
        if (!contractTemplateBO.isContractTemplateExist(id)) {
            throw new BizException("ZC000001", "序号不存在");
        }

        ContractTemplate data = new ContractTemplate();
        data.setId(id);
        data.setTitle(title);
        data.setContent(content);
        data.setType(type);
        data.setStatus(status);
        data.setUpdater(updater);
        data.setRemark(remark);
        contractTemplateBO.refreshContractTemplate(data);

    }

}

package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.ContractTemplate;
import com.xnjr.mall.spring.ServiceModule;

@ServiceModule
public interface IContractTemplateAO {

    String DEFAULT_ORDER_COLUMN = "id";

    List<ContractTemplate> queryContractTemplateList(ContractTemplate condition);

    Paginable<ContractTemplate> queryContractTemplatePage(int start, int limit,
            ContractTemplate condition);

    ContractTemplate getContractTemplate(Long id);

    Long addContractTemplate(String title, String content, String type,
            String status, String updater, String remark);

    void dropContractTemplate(Long id);

    void editContractTemplate(Long id, String title, String content,
            String type, String status, String updater, String remark);

}

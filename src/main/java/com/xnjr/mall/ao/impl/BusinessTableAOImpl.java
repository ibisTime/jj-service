package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IBusinessTableAO;
import com.xnjr.mall.bo.IBusinessTableBO;
import com.xnjr.mall.domain.BusinessTable;

/** 
 * @author: wuql
 * @since: 2016年1月19日 下午1:23:03 
 * @history:
 */
@Service
public class BusinessTableAOImpl implements IBusinessTableAO {
    @Autowired
    IBusinessTableBO businessTableBO;

    @Override
    public List<BusinessTable> queryBusinessTableList(String businessCode) {
        return businessTableBO.queryBusinessTableList(businessCode);
    }
}

/**
 * @Title BusinessTableBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年1月17日 下午3:32:21 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IBusinessTableBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IBusinessTableDAO;
import com.xnjr.mall.domain.BusinessTable;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: wuql
 * @since: 2016年1月19日 下午5:30:09 
 * @history:
 */
@Component
public class BusinessTableBOImpl extends PaginableBOImpl<BusinessTable>
        implements IBusinessTableBO {
    @Autowired
    private IBusinessTableDAO businessTableDAO;

    @Override
    public void saveBusinessTable(BusinessTable data) {
        if (data != null && StringUtils.isNotBlank(data.getBusinessCode())) {
            businessTableDAO.insert(data);
        } else {
            throw new BizException("XN000000", "业务编号不能为空");
        }
    }

    @Override
    public void removeBusinessTable(String businessCode) {
        if (StringUtils.isNotBlank(businessCode)) {
            BusinessTable condition = new BusinessTable();
            condition.setBusinessCode(businessCode);
            businessTableDAO.deleteBusinessTable(condition);
        }
    }

    @Override
    public List<BusinessTable> queryBusinessTableList(String businessCode) {
        List<BusinessTable> list = null;
        if (StringUtils.isNotBlank(businessCode)) {
            BusinessTable condition = new BusinessTable();
            condition.setBusinessCode(businessCode);
            list = businessTableDAO.selectList(condition);
        }
        return list;
    }
}

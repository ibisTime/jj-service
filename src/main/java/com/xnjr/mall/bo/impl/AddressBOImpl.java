/**
 * @Title AddressBOImpl.java 
 * @Package com.xnjr.cpzc.user.impl 
 * @Description 
 * @author xieyj  
 * @date 2015年8月27日 上午9:44:01 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IAddressBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IAddressDAO;
import com.xnjr.mall.domain.Address;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午9:44:01 
 * @history:
 */
@Component
public class AddressBOImpl extends PaginableBOImpl<Address> implements
        IAddressBO {
    @Autowired
    private IAddressDAO addressDAO;

    @Override
    public String saveAddress(Address data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.AD.getCode());
            data.setCode(code);
            addressDAO.insert(data);
        }
        return code;
    }

    @Override
    public int deleteAddress(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Address data = new Address();
            data.setCode(code);
            count = addressDAO.delete(data);
        }
        return count;
    }

    @Override
    public int refreshAddress(Address data) {
        int count = 0;
        if (StringUtils.isNotBlank(data.getCode())) {
            count = addressDAO.update(data);
        }
        return count;
    }

    @Override
    public List<Address> queryAddressList(Address data) {
        return addressDAO.selectList(data);
    }

    @Override
    public int refreshAddressDef(String code, String isDefault) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Address addressDO = new Address();
            addressDO.setCode(code);
            addressDO.setIsDefault(isDefault);
            count = addressDAO.updateAddressDef(addressDO);
        }
        return count;
    }

    @Override
    public int refreshAddressDefByUser(String userId, String isDefault) {
        int count = 0;
        if (StringUtils.isNotBlank(userId)) {
            Address data = new Address();
            data.setUserId(userId);
            data.setIsDefault(isDefault);
            count = addressDAO.updateAddressDefByUser(data);
        }
        return count;
    }

    /**
     * 
     * @see com.xnjr.cpzc.user.IAddressBO#getAddress(java.lang.String)
     */
    @Override
    public Address getAddress(String code) {
        Address address = null;
        if (StringUtils.isNotBlank(code)) {
            Address condition = new Address();
            condition.setCode(code);
            address = addressDAO.select(condition);
        }
        return address;
    }
}

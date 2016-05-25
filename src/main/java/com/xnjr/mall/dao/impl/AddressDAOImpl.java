package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IAddressDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Address;

/**
 * @author: luoqi 
 * @since: 2015年3月7日 下午3:49:54 
 * @history:
 */
@Repository("addressDAOImpl")
public class AddressDAOImpl extends AMybatisTemplate implements IAddressDAO {

    @Override
    public int insert(Address data) {
        return super.insert(NAMESPACE.concat("insert_address"), data);
    }

    @Override
    public int delete(Address data) {
        return super.delete(NAMESPACE.concat("delete_address"), data);
    }

    @Override
    public Address select(Address condition) {
        return super.select(NAMESPACE.concat("select_address"), condition,
            Address.class);
    }

    @Override
    public Long selectTotalCount(Address condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_address_count"),
            condition);
    }

    @Override
    public List<Address> selectList(Address condition) {
        return super.selectList(NAMESPACE.concat("select_address"), condition,
            Address.class);
    }

    @Override
    public List<Address> selectList(Address condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_address"), start,
            count, condition, Address.class);
    }

    @Override
    public int update(Address data) {
        return super.update(NAMESPACE.concat("update_address"), data);
    }

    /** 
     * @see com.xnjr.cpzc.IAddressDAO#updateDefAddr(com.xnjr.cpzc.domain.Address)
     */
    @Override
    public int updateAddressDef(Address data) {
        return super.update(NAMESPACE.concat("update_addressDef"), data);
    }

    /** 
     * @see com.xnjr.cpzc.IAddressDAO#updatDefByUser(com.xnjr.cpzc.domain.AddressDO)
     */
    @Override
    public int updateAddressDefByUser(Address data) {
        return super.update(NAMESPACE.concat("update_addressDefByUser"), data);
    }
}

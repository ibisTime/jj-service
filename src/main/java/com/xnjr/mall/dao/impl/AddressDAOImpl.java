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

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Address data) {
        return super.insert(NAMESPACE.concat("insert_address"), data);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Address data) {
        return super.delete(NAMESPACE.concat("delete_address"), data);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Address select(Address condition) {
        return super.select(NAMESPACE.concat("select_address"), condition,
            Address.class);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Address condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_address_count"),
            condition);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Address> selectList(Address condition) {
        return super.selectList(NAMESPACE.concat("select_address"), condition,
            Address.class);
    }

    /** 
     * @see com.xnjr.cpzc.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Address> selectList(Address condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_address"), start,
            count, condition, Address.class);
    }

    /** 
     * @see com.xnjr.cpzc.IAddressDAO#update(com.xnjr.cpzc.domain.Address)
     */
    @Override
    public int update(Address data) {
        return super.update(NAMESPACE.concat("update_address"), data);
    }

    /** 
     * @see com.xnjr.cpzc.IAddressDAO#updateDefAddr(com.xnjr.cpzc.domain.Address)
     */
    @Override
    public int updateAddressDef(Address data) {
        return super.update(NAMESPACE.concat("update_address_def"), data);
    }
}

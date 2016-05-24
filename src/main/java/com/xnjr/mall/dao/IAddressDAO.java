package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Address;

/**
 * @author: luoqi 
 * @since: 2015年3月7日 下午3:48:14 
 * @history:
 */
public interface IAddressDAO extends IBaseDAO<Address> {
    String NAMESPACE = IAddressDAO.class.getName().concat(".");

    /**
     * 更新收件地址
     * @param data
     * @return 
     * @create: 2015年8月26日 下午11:27:59 xieyj
     * @history:
     */
    public int update(Address data);

    /**
     * 更新默认收件地址
     * @param data
     * @return 
     * @create: 2015年8月26日 下午11:28:13 xieyj
     * @history:
     */
    public int updateAddressDef(Address data);
}

package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.domain.Address;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午10:39:37 
 * @history:
 */
public interface IAddressAO {

    /**
     * 新增地址
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:02 xieyj
     * @history:
     */
    public String addAddress(Address data);

    /**
     * 删除地址
     * @param code
     * @return 
     * @create: 2015年8月27日 下午2:22:15 xieyj
     * @history:
     */
    public int dropAddress(String code);

    /**
     * 修改地址
     * @param data
     * @return 
     * @create: 2015年8月27日 下午2:22:25 xieyj
     * @history:
     */
    public int editAddress(Address data);

    /**
     * 设置默认地址
     * @param userId
     * @param code
     * @return 
     * @create: 2016年5月23日 下午9:15:44 xieyj
     * @history:
     */
    public int setDefaultAddress(String userId, String code);

    /**
     * 修改默认地址
     * @param userId
     * @param code
     * @param isDefault
     * @return 
     * @create: 2016年5月23日 下午9:15:31 xieyj
     * @history:
     */
    public int refreshAddressDef(String userId, String code, String isDefault);

    /**
     * 查询收件地址
     * @param condition
     * @return 
     * @create: 2015年8月27日 下午2:22:56 xieyj
     * @history:
     */
    public List<Address> queryAddressList(Address condition);

    /**
     * 收件地址详情
     * @param code
     * @return 
     * @create: 2016年5月24日 下午3:13:59 xieyj
     * @history:
     */
    public Address getAddress(String code);

}

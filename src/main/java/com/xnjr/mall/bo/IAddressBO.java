/**
 * @Title IAddress.java 
 * @Package com.xnjr.cpzc.user 
 * @Description 
 * @author xieyj  
 * @date 2015年8月27日 上午9:42:44 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Address;

/** 
 * @author: xieyj 
 * @since: 2015年8月27日 上午9:42:44 
 * @history:
 */
public interface IAddressBO extends IPaginableBO<Address> {

    /**
     * 保存收件地址
     * @param data
     * @return 
     * @create: 2015年8月21日 下午5:06:38 xieyj
     * @history:
     */
    public String saveAddress(Address data);

    /**
     * 删除收件地址
     * @param code
     * @return 
     * @create: 2016年5月23日 下午9:09:04 xieyj
     * @history:
     */
    public int deleteAddress(String code);

    /**
     * 更新收件地址
     * @param data
     * @return 
     * @create: 2016年5月23日 下午9:08:49 xieyj
     * @history:
     */
    public int refreshAddress(Address data);

    /**
     * 更新收件地址默认状态
     * @param code
     * @param isDefault
     * @return 
     * @create: 2016年5月23日 下午9:08:41 xieyj
     * @history:
     */
    public int refreshAddressDef(String code, String isDefault);

    /**
     * 更新收件地址默认状态
     * @param userId
     * @param isDefault
     * @return 
     * @create: 2016年5月23日 下午9:08:29 xieyj
     * @history:
     */
    public int refreshAddressDefByUser(String userId, String isDefault);

    /**
     * 查询收件地址列表
     * @param data
     * @return 
     * @create: 2015年8月21日 下午5:07:41 xieyj
     * @history:
     */
    public List<Address> queryAddressList(Address data);

    /**
     * 根据收件地址编号获取详细信息
     * @param code
     * @return 
     * @create: 2016年5月23日 下午9:08:14 xieyj
     * @history:
     */
    public Address getAddress(String code);

}

/**
 * @Title IProductBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:04:57 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Product;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:04:57 
 * @history:
 */
public interface IProductBO extends IPaginableBO<Product> {

    public boolean isProductExist(String code);

    public String saveProduct(Product product);

    public int removeProduct(String code);

    public int refreshProduct(Product product);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code);

    public List<Product> queryProductType(Product condition);

    /**
     * 审核产品通过
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:20:40 haiqingzheng
     * @history:
     */
    public int approveProduct(String code, String checkUser, String checkNote);

    /**
     * 审核产品不通过
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:20:56 haiqingzheng
     * @history:
     */
    public int unApproveProduct(String code, String checkUser, String checkNote);

    /**
     * 上架产品
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:24:04 haiqingzheng
     * @history:
     */
    public int putOn(String code, String checkUser, String checkNote);

    /**
     * 下架产品
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:24:14 haiqingzheng
     * @history:
     */
    public int putOff(String code, String checkUser, String checkNote);
}

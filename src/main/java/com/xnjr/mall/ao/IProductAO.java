/**
 * @Title IProductAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:33:00 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Product;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:33:00 
 * @history:
 */
public interface IProductAO {

    public String addProduct(Product product);

    public int dropProduct(String code);

    public int editProduct(Product product);

    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition);

    public List<Product> queryProductList(Product condition);

    public Product getProduct(String code);

}

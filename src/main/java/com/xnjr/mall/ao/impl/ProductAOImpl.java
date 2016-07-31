/**
 * @Title ProductAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:37:38 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IProductAO;
import com.xnjr.mall.bo.IProductBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Product;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EPutStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:37:38 
 * @history:
 */
@Service
public class ProductAOImpl implements IProductAO {

    @Autowired
    private IProductBO productBO;

    /** 
     * @see com.xnjr.mall.ao.IProductAO#addProduct(com.xnjr.mall.domain.Product)
     */
    @Override
    public String addProduct(Product product) {
        Product condition = new Product();
        condition.setName(product.getName());
        List<Product> list = productBO.queryProductList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            throw new BizException("jd00001", "产品名称已存在");
        }
        String code = null;
        if (product != null) {
            code = productBO.saveProduct(product);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.ao.IProductAO#dropProduct(java.lang.String)
     */
    @Override
    public int dropProduct(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            count = productBO.removeProduct(code);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.IProductAO#updateProduct(com.xnjr.mall.domain.Product)
     */
    @Override
    public int editProduct(Product product) {
        Product condition = new Product();
        condition.setCode(product.getCode());
        List<Product> list = productBO.queryProductList(condition);
        if (!CollectionUtils.sizeIsEmpty(list)) {
            throw new BizException("jd00001", "产品不存在");
        }
        int count = 0;
        count = productBO.refreshProduct(product);
        return count;
    }

    /** 
     * @see com.xnjr.mall.ao.IProductAO#queryProductPage(int, int, com.xnjr.mall.domain.Product)
     */
    @Override
    public Paginable<Product> queryProductPage(int start, int limit,
            Product condition) {
        return productBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IProductAO#queryProductList(com.xnjr.mall.domain.Product)
     */
    @Override
    public List<Product> queryProductList(Product condition) {
        return productBO.queryProductList(condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IProductAO#getProduct(java.lang.String)
     */
    @Override
    public Product getProduct(String code) {
        return productBO.getProduct(code);
    }

    @Override
    public int checkProduct(String code, String checkUser, String checkResult,
            String checkNote) {
        int count = 0;
        Product product = productBO.getProduct(code);
        if (!EPutStatus.todoAPPROVE.getCode().equals(product.getStatus())) {
            throw new BizException("xn000000", "该产品不处于待审核状态");
        }
        if (EBoolean.YES.getCode().equals(checkResult)) {
            count = productBO.approveProduct(code, checkUser, checkNote);
        } else if (EBoolean.NO.getCode().equals(checkResult)) {
            count = productBO.unApproveProduct(code, checkUser, checkNote);
        } else {
            throw new BizException("xn000000", "审核结果传值有误");
        }
        return count;
    }

    @Override
    public int putOnOffProduct(String code, String checkUser,
            String checkResult, String checkNote) {
        int count = 0;
        Product product = productBO.getProduct(code);
        if (EBoolean.YES.getCode().equals(checkResult)) {
            if (!EPutStatus.APPROVE_YES.getCode().equals(product.getStatus())) {
                throw new BizException("xn000000", "该产品不处于审核通过状态，不能上架");
            }
            count = productBO.putOn(code, checkUser, checkNote);
        } else if (EBoolean.NO.getCode().equals(checkResult)) {
            if (!EPutStatus.ONLINE.getCode().equals(product.getStatus())) {
                throw new BizException("xn000000", "该产品不处于上架状态，不能下架");
            }
            count = productBO.putOff(code, checkUser, checkNote);
        } else {
            throw new BizException("xn000000", "审核结果传值有误");
        }
        return count;
    }

    @Override
    public List<Product> queryProductType(Product condition) {
        return productBO.queryProductType(condition);
    }
}

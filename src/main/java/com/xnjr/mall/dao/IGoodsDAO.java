/**
 * @Title IGoodsDAO.java 
 * @Package com.xnjr.mall.dao 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 上午11:22:51 
 * @version V1.0   
 */
package com.xnjr.mall.dao;

import java.util.List;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 上午11:22:51 
 * @history:
 */
public interface IGoodsDAO extends IBaseDAO<Goods> {
    String NAMESPACE = IGoodsDAO.class.getName().concat(".");

    public List<Goods> queryGoodsInLogistics(Goods condition);
}

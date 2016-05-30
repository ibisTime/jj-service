/**
 * @Title IGoodsBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午12:55:15 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午12:55:15 
 * @history:
 */
public interface IGoodsBO extends IPaginableBO<Goods> {
    public String saveGoods(Goods data);

    public Goods getGoods(String code);

    public List<Goods> queryGoodsInLogistics(String logisticsCode);
}

/**
 * @Title GoodsBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午12:59:35 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IGoodsBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IGoodsDAO;
import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午12:59:35 
 * @history:
 */
@Component
public class GoodsBOImpl extends PaginableBOImpl<Goods> implements IGoodsBO {

    @Autowired
    private IGoodsDAO goodsDAO;

    /** 
     * @see com.xnjr.mall.bo.IGoodsBO#saveGoods(com.xnjr.mall.domain.Goods)
     */
    @Override
    public String saveGoods(Goods data) {
        String code = null;
        if (data != null) {
            goodsDAO.insert(data);
            code = data.getCode();
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IGoodsBO#getGoods(java.lang.String)
     */
    @Override
    public Goods getGoods(String code) {
        Goods goods = null;
        if (StringUtils.isNotBlank(code)) {
            Goods condition = new Goods();
            condition.setCode(code);
            goods = goodsDAO.select(condition);
        }
        return goods;
    }

    @Override
    public List<Goods> queryGoodsInLogistics(String logisticsCode) {
        List<Goods> goodsList = null;
        if (StringUtils.isNotBlank(logisticsCode)) {
            Goods condition = new Goods();
            condition.setLogisticsCode(logisticsCode);
            goodsDAO.queryGoodsInLogistics(condition);
        }
        return goodsList;
    }

}

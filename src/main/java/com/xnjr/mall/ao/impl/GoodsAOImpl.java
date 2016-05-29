/**
 * @Title GoodsAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午1:26:23 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IGoodsAO;
import com.xnjr.mall.bo.IGoodsBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午1:26:23 
 * @history:
 */
@Service
public class GoodsAOImpl implements IGoodsAO {

    @Autowired
    IGoodsBO goodsBO;

    /** 
     * @see com.xnjr.mall.ao.IGoodsAO#getGoods(java.lang.String)
     */
    @Override
    public Goods getGoods(String code) {
        Goods goods = null;
        if (StringUtils.isNotBlank(code)) {
            goods = goodsBO.getGoods(code);
        }
        return goods;
    }

    /** 
     * @see com.xnjr.mall.ao.IGoodsAO#queryGoodsPage(int, int, com.xnjr.mall.domain.Goods)
     */
    @Override
    public Paginable<Goods> queryGoodsPage(int start, int limit, Goods condition) {
        return goodsBO.getPaginable(start, limit, condition);
    }

    /** 
     * @see com.xnjr.mall.ao.IGoodsAO#getGoodsCodeStart(java.lang.String)
     */
    @Override
    public String getGoodsCodeStart(String modelCode) {
        String startCode = null;
        if (StringUtils.isNotBlank(modelCode)) {
            Goods goods = new Goods();
            goods.setModelCode(modelCode);
            Long count = goodsBO.getTotalCount(goods);
            Long goodsCode = count + 1;
            startCode = modelCode + "-" + goodsCode;
        }
        return startCode;
    }
}

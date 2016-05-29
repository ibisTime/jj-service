/**
 * @Title GoodsDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 上午11:53:01 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IGoodsDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Goods;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 上午11:53:01 
 * @history:
 */
@Repository("goodsDAOImpl")
public class GoodsDAOImpl extends AMybatisTemplate implements IGoodsDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Goods data) {
        return super.insert(NAMESPACE.concat("insert_goods"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Goods data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Goods select(Goods condition) {
        return super.select(NAMESPACE.concat("select_goods"), condition,
            Goods.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Goods condition) {
        return super.selectTotalCount(NAMESPACE.concat("select_goods_count"),
            condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Goods> selectList(Goods condition) {
        return super.selectList(NAMESPACE.concat("select_goods"), condition,
            Goods.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Goods> selectList(Goods condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_goods"), start, count,
            condition, Goods.class);
    }

    /**
     * @see com.xnjr.mall.dao.IGoodsDAO#queryGoodsInLogistics(com.xnjr.mall.domain.Goods)
     */
    @Override
    public List<Goods> queryGoodsInLogistics(Goods condition) {
        return super.selectList(NAMESPACE.concat("select_goodsInLogistics"),
            condition, Goods.class);
    }

}

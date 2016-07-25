/**
 * @Title SaleGuideDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年7月25日 下午3:09:07 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.ISaleGuideDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.SaleGuide;

/** 
 * @author: haiqingzheng 
 * @since: 2016年7月25日 下午3:09:07 
 * @history:
 */
@Repository("saleGuideDAOImpl")
public class SaleGuideDAOImpl extends AMybatisTemplate implements ISaleGuideDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(SaleGuide data) {
        return super.insert(NAMESPACE.concat("insert_saleGuide"), data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(SaleGuide data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public SaleGuide select(SaleGuide condition) {
        return super.select(NAMESPACE.concat("select_saleGuide"), condition,
            SaleGuide.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(SaleGuide condition) {
        return super.selectTotalCount(
            NAMESPACE.concat("select_saleGuide_count"), condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<SaleGuide> selectList(SaleGuide condition) {
        return super.selectList(NAMESPACE.concat("select_saleGuide"),
            condition, SaleGuide.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<SaleGuide> selectList(SaleGuide condition, int start, int count) {
        return super.selectList(NAMESPACE.concat("select_saleGuide"), start,
            count, condition, SaleGuide.class);
    }

    /** 
     * @see com.xnjr.mall.dao.ISaleGuideDAO#update(com.xnjr.mall.domain.SaleGuide)
     */
    @Override
    public int update(SaleGuide data) {
        return super.update(NAMESPACE.concat("update_saleGuide"), data);
    }

}

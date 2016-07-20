/**
 * @Title IntegralDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月20日 下午5:21:08 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IIntegralDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Integral;

/** 
 * @author: xieyj 
 * @since: 2016年7月20日 下午5:21:08 
 * @history:
 */
@Repository("integralDAOImpl")
public class IntegralDAOImpl extends AMybatisTemplate implements IIntegralDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Integral data) {
        return super.insert("insert_integral", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Integral data) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Integral select(Integral condition) {
        return super.select("select_integral", condition, Integral.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Integral condition) {
        return super.selectTotalCount("select_integral_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Integral> selectList(Integral condition) {
        return super.selectList("select_integral", condition, Integral.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Integral> selectList(Integral condition, int start, int count) {
        return super.selectList("select_integral", start, count, condition,
            Integral.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IIntegralDAO#updateStatus(com.xnjr.mall.domain.BuyGuide)
     */
    @Override
    public int updateStatus(Integral data) {
        return super.update("update_integralStatus", data);
    }
}

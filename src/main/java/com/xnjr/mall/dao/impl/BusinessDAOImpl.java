/**
 * @Title BusinessDAOImpl.java 
 * @Package com.xnjr.moom.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年1月17日 上午10:45:39 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IBusinessDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Business;

/** 业务
 * @author: xieyj 
 * @since: 2016年1月17日 上午10:45:39 
 * @history:
 */
@Repository("businessDAOImpl")
public class BusinessDAOImpl extends AMybatisTemplate implements IBusinessDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Business data) {
        return super.insert("insert_business", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Business data) {
        return 0;
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Business select(Business condition) {
        return super.select("select_business", condition, Business.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Business condition) {
        return super.selectTotalCount("select_business_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Business> selectList(Business condition) {
        return super.selectList("select_business", condition, Business.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Business> selectList(Business condition, int start, int count) {
        return super.selectList("select_business", start, count, condition,
            Business.class);
    }

    @Override
    public int unpassBusiness(Business business) {
        return super.update("update_unpassBusiness", business);
    }

    @Override
    public int passBusiness(Business business) {
        return super.update("update_passBusiness", business);
    }

    @Override
    public int updateBusiness(Business business) {
        return super.update("update_updateBusiness", business);
    }

    @Override
    public int updateContract(Business business) {
        return super.update("update_contract", business);
    }
}

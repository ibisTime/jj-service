/**
 * @Title ModelSpecsDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 上午11:49:25 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IModelSpecsDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.ModelSpecs;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 上午11:49:25 
 * @history:
 */
@Repository("modelSpecsDAOImpl")
public class ModelSpecsDAOImpl extends AMybatisTemplate implements
        IModelSpecsDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(ModelSpecs data) {
        return super.insert("insert_modelSpecs", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(ModelSpecs data) {
        return super.delete("delete_modelSpecs", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int deleteByModelCode(ModelSpecs data) {
        return super.delete("delete_modelSpecsByModelCode", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public ModelSpecs select(ModelSpecs condition) {
        return super.select("select_modelSpecs", condition, ModelSpecs.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(ModelSpecs condition) {
        return super.selectTotalCount("select_modelSpecs_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<ModelSpecs> selectList(ModelSpecs condition) {
        return super.selectList("select_modelSpecs", condition,
            ModelSpecs.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<ModelSpecs> selectList(ModelSpecs condition, int start,
            int count) {
        return super.selectList("select_modelSpecs", start, count, condition,
            ModelSpecs.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IModelSpecsDAO#updateModelSpecs(com.xnjr.mall.domain.ModelSpecs)
     */
    @Override
    public int updateModelSpecs(ModelSpecs modelSpecs) {
        return super.update("update_modelSpecs", modelSpecs);
    }
}

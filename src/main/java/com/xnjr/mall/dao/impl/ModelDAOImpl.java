/**
 * @Title ModelDAOImpl.java 
 * @Package com.xnjr.mall.dao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 上午11:49:25 
 * @version V1.0   
 */
package com.xnjr.mall.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xnjr.mall.dao.IModelDAO;
import com.xnjr.mall.dao.base.support.AMybatisTemplate;
import com.xnjr.mall.domain.Model;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 上午11:49:25 
 * @history:
 */
@Repository("modelDAOImpl")
public class ModelDAOImpl extends AMybatisTemplate implements IModelDAO {

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#insert(java.lang.Object)
     */
    @Override
    public int insert(Model data) {
        return super.insert("insert_model", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#delete(java.lang.Object)
     */
    @Override
    public int delete(Model data) {
        return super.delete("delete_model", data);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#select(java.lang.Object)
     */
    @Override
    public Model select(Model condition) {
        return super.select("select_model", condition, Model.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectTotalCount(java.lang.Object)
     */
    @Override
    public Long selectTotalCount(Model condition) {
        return super.selectTotalCount("select_model_count", condition);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object)
     */
    @Override
    public List<Model> selectList(Model condition) {
        return super.selectList("select_model", condition, Model.class);
    }

    /** 
     * @see com.xnjr.mall.dao.base.IBaseDAO#selectList(java.lang.Object, int, int)
     */
    @Override
    public List<Model> selectList(Model condition, int start, int count) {
        return super.selectList("select_model", start, count, condition,
            Model.class);
    }

    /** 
     * @see com.xnjr.mall.dao.IModelDAO#updateModel(com.xnjr.mall.domain.Model)
     */
    @Override
    public int updateModel(Model model) {
        return super.update("update_model", model);
    }

    @Override
    public int updateModelStatus(Model model) {
        return super.update("update_modelStatus", model);
    }

}

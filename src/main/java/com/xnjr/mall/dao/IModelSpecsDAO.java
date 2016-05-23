package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.ModelSpecs;

/**
 * @author: xieyj 
 * @since: 2016年5月23日 上午11:48:46 
 * @history:
 */
public interface IModelSpecsDAO extends IBaseDAO<ModelSpecs> {
    String NAMESPACE = IModelSpecsDAO.class.getName().concat(".");

    public int deleteByModelCode(ModelSpecs data);

    public int updateModelSpecs(ModelSpecs data);
}

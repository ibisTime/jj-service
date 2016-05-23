package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.Model;

/**
 * @author: xieyj 
 * @since: 2016年5月23日 上午11:48:46 
 * @history:
 */
public interface IModelDAO extends IBaseDAO<Model> {
    String NAMESPACE = IModelDAO.class.getName().concat(".");

    public int updateModel(Model model);

    public int updateModelStatus(Model model);
}

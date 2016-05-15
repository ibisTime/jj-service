package com.xnjr.mall.dao;

import com.xnjr.mall.dao.base.IBaseDAO;
import com.xnjr.mall.domain.GSStructure;

/**
 * 结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午10:58:35 
 * @history:
 */
public interface IGSStructureDAO extends IBaseDAO<GSStructure> {
    String NAMESPACE = IGSStructureDAO.class.getName().concat(".");

    public int updateStructure(GSStructure data);
}

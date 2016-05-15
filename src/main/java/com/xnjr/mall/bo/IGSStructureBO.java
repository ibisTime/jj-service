package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.GSStructure;

/**
 * 结构
 * @author: Gejin 
 * @since: 2016年4月13日 上午11:20:31 
 * @history:
 */
public interface IGSStructureBO extends IPaginableBO<GSStructure> {

    public String saveStructure(GSStructure data);

    public int refreshStructure(GSStructure data);

    public int removeStructure(String code);

    public List<GSStructure> queryStructureList(GSStructure data);

    public GSStructure getStructure(String code);

    public boolean isStructureExist(String code);

}

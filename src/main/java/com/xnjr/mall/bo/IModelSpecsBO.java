/**
 * @Title IModelSpecsBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 下午12:00:01 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.ModelSpecs;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 下午12:00:01 
 * @history:
 */
public interface IModelSpecsBO extends IPaginableBO<ModelSpecs> {

    public boolean isModelSpecsExist(String code);

    public String saveModelSpecs(ModelSpecs data);

    public int removeModelSpecsByModeCode(String modeCode);

    public int refreshModelSpecs(ModelSpecs data);

    public List<ModelSpecs> queryModelSpecsList(ModelSpecs condition);

    public ModelSpecs getModelSpecs(String code);

}

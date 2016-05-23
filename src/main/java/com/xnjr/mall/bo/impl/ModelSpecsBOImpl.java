/**
 * @Title ModelSpecsBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 下午12:00:44 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IModelSpecsBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IModelSpecsDAO;
import com.xnjr.mall.domain.ModelSpecs;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 下午12:00:44 
 * @history:
 */
@Component
public class ModelSpecsBOImpl extends PaginableBOImpl<ModelSpecs> implements
        IModelSpecsBO {

    @Autowired
    private IModelSpecsDAO modelSpecsDAO;

    /** 
     * @see com.xnjr.mall.bo.base.IPaginableBO#getTotalCount(com.xnjr.mall.dao.base.ABaseDO)
     */
    @Override
    public long getTotalCount(ModelSpecs condition) {
        return modelSpecsDAO.selectTotalCount(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IModelSpecsBO#isModelSpecsExist(java.lang.String)
     */
    @Override
    public boolean isModelSpecsExist(String code) {
        ModelSpecs condition = new ModelSpecs();
        condition.setCode(code);
        if (modelSpecsDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelSpecsBO#saveModelSpecs(com.xnjr.mall.domain.ModelSpecs)
     */
    @Override
    public String saveModelSpecs(ModelSpecs data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("MS");
            data.setCode(code);
            modelSpecsDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelSpecsBO#removeModelSpecs(java.lang.String)
     */
    @Override
    public int removeModelSpecsByModeCode(String modelCode) {
        int count = 0;
        if (StringUtils.isNotBlank(modelCode)) {
            ModelSpecs data = new ModelSpecs();
            data.setModelCode(modelCode);
            count = modelSpecsDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelSpecsBO#refreshModelSpecs(com.xnjr.mall.domain.ModelSpecs)
     */
    @Override
    public int refreshModelSpecs(ModelSpecs data) {
        int count = 0;
        if (data != null) {
            if (!isModelSpecsExist(data.getCode())) {
                throw new BizException("xn000000", "型号规格编号不存在");
            }
            count = modelSpecsDAO.updateModelSpecs(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelSpecsBO#queryModelSpecsList(com.xnjr.mall.domain.ModelSpecs)
     */
    @Override
    public List<ModelSpecs> queryModelSpecsList(ModelSpecs condition) {
        return modelSpecsDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IModelSpecsBO#getModelSpecs(java.lang.String)
     */
    @Override
    public ModelSpecs getModelSpecs(String code) {
        ModelSpecs data = null;
        if (StringUtils.isNotBlank(code)) {
            ModelSpecs condition = new ModelSpecs();
            condition.setCode(code);
            data = modelSpecsDAO.select(condition);
            if (data == null) {
                throw new BizException("xn000000", "型号规格编号不存在");
            }
        }
        return data;
    }
}

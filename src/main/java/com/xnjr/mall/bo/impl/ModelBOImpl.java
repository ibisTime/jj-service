/**
 * @Title ModelBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 上午11:58:36 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IModelDAO;
import com.xnjr.mall.domain.Model;
import com.xnjr.mall.enums.EPutStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 上午11:58:36 
 * @history:
 */
@Component
public class ModelBOImpl extends PaginableBOImpl<Model> implements IModelBO {

    @Autowired
    private IModelDAO modelDAO;

    /** 
     * @see com.xnjr.mall.bo.IModelBO#isModelExist(java.lang.String)
     */
    @Override
    public boolean isModelExist(String code) {
        Model condition = new Model();
        condition.setCode(code);
        if (modelDAO.selectTotalCount(condition) == 1) {
            return true;
        }
        return false;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#saveModel(com.xnjr.mall.domain.Model)
     */
    @Override
    public String saveModel(Model data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM("MM");
            data.setCode(code);
            data.setUpdateDatetime(new Date());
            if (data.getRemark() == null
                    || "".equalsIgnoreCase(data.getRemark())) {
                data.setRemark("型号新增");
            }
            modelDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#removeModel(java.lang.String)
     */
    @Override
    public int removeModel(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            if (!isModelExist(code)) {
                throw new BizException("xn000000", "型号编号不存在");
            }
            Model data = new Model();
            data.setCode(code);
            count = modelDAO.delete(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#refreshModel(com.xnjr.mall.domain.Model)
     */
    @Override
    public int refreshModel(Model data) {
        int count = 0;
        if (data != null) {
            if (!isModelExist(data.getCode())) {
                throw new BizException("xn000000", "型号编号不存在");
            }
            data.setUpdateDatetime(new Date());
            data.setStatus(EPutStatus.todoAPPROVE.getCode());
            data.setRemark("型号信息被编辑，重新提交审核");
            count = modelDAO.updateModel(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#queryModelList(com.xnjr.mall.domain.Model)
     */
    @Override
    public List<Model> queryModelList(Model condition) {
        return modelDAO.selectList(condition);

    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#getModel(java.lang.String)
     */
    @Override
    public Model getModel(String code) {
        Model data = null;
        if (StringUtils.isNotBlank(code)) {
            Model condition = new Model();
            condition.setCode(code);
            data = modelDAO.select(condition);
            if (data == null) {
                throw new BizException("xn000000", "型号编号不存在");
            }
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#approveModel(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int approveModel(String code, String checkUser, String checkNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Model data = new Model();
            data.setCode(code);
            data.setUpdater(checkUser);
            data.setUpdateDatetime(new Date());
            data.setStatus(EPutStatus.APPROVE_YES.getCode());
            data.setRemark(checkNote);
            count = modelDAO.updateModelStatus(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#unApproveModel(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int unApproveModel(String code, String checkUser, String checkNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Model data = new Model();
            data.setCode(code);
            data.setUpdater(checkUser);
            data.setUpdateDatetime(new Date());
            data.setStatus(EPutStatus.APPROVE_NO.getCode());
            data.setRemark(checkNote);
            count = modelDAO.updateModelStatus(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#putOn(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int putOn(String code, String checkUser, String checkNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Model data = new Model();
            data.setCode(code);
            data.setUpdater(checkUser);
            data.setUpdateDatetime(new Date());
            data.setStatus(EPutStatus.ONLINE.getCode());
            data.setRemark(checkNote);
            count = modelDAO.updateModelStatus(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IModelBO#putOff(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int putOff(String code, String checkUser, String checkNote) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Model data = new Model();
            data.setCode(code);
            data.setUpdater(checkUser);
            data.setUpdateDatetime(new Date());
            data.setStatus(EPutStatus.todoAPPROVE.getCode());
            data.setRemark(checkNote);
            count = modelDAO.updateModelStatus(data);
        }
        return count;
    }

}

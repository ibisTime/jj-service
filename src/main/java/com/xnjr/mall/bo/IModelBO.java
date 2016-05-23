/**
 * @Title IModelBO.java 
 * @Package com.xnjr.mall.bo 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月16日 下午9:04:57 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Model;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月16日 下午9:04:57 
 * @history:
 */
public interface IModelBO extends IPaginableBO<Model> {

    public boolean isModelExist(String code);

    public String saveModel(Model data);

    public int removeModel(String code);

    public int refreshModel(Model data);

    public List<Model> queryModelList(Model condition);

    public Model getModel(String code);

    /**
     * 审核产品通过
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:20:40 haiqingzheng
     * @history:
     */
    public int approveModel(String code, String checkUser, String checkNote);

    /**
     * 审核产品不通过
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:20:56 haiqingzheng
     * @history:
     */
    public int unApproveModel(String code, String checkUser, String checkNote);

    /**
     * 上架产品
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:24:04 haiqingzheng
     * @history:
     */
    public int putOn(String code, String checkUser, String checkNote);

    /**
     * 下架产品
     * @param code
     * @param checkUser
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:24:14 haiqingzheng
     * @history:
     */
    public int putOff(String code, String checkUser, String checkNote);
}

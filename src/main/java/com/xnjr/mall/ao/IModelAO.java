/**
 * @Title IModelAO.java 
 * @Package com.xnjr.mall.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年5月23日 上午9:01:54 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Model;

/** 
 * @author: xieyj 
 * @since: 2016年5月23日 上午9:01:54 
 * @history:
 */
public interface IModelAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addModel(Model model);

    public int editModel(Model model);

    public Paginable<Model> queryModelPage(int start, int limit, Model condition);

    public List<Model> queryModelList(Model condition);

    public Model getModel(String code);

    /**
     * 审核产品
     * @param code
     * @param checkUser
     * @param checkResult
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:27:16 haiqingzheng
     * @history:
     */
    public int checkModel(String code, String checkUser, String checkResult,
            String checkNote);

    /**
     * 上架/下架产品
     * @param code
     * @param checkUser
     * @param checkResult 1上架 0下架
     * @param checkNote
     * @return 
     * @create: 2016年5月17日 上午11:28:12 haiqingzheng
     * @history:
     */
    public int putOnOffModel(String code, String checkUser, String checkResult,
            String checkNote);
}

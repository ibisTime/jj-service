/**
 * @Title IFDIndividualBO.java 
 * @Package com.xnjr.moom.bo 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午9:05:38 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDIndividual;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:05:38 
 * @history:
 */
public interface IFDIndividualBO extends IPaginableBO<FDIndividual> {

    /**
     * 获取详情
     * @param code
     * @return 
     * @create: 2016年4月22日 下午9:07:44 xieyj
     * @history:
     */
    public FDIndividual getIndividual(String code);

    /**
     * 获取列表
     * @param data
     * @return 
     * @create: 2016年4月22日 下午9:08:39 xieyj
     * @history:
     */
    public List<FDIndividual> queryIndividualList(FDIndividual data);
}

/**
 * @Title IFDIndividualAO.java 
 * @Package com.xnjr.moom.ao 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午9:16:43 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import java.util.List;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDIndividual;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:16:43 
 * @history:
 */
@ServiceModule
public interface IFDIndividualAO {
    String DEFAULT_ORDER_COLUMN = "code";

    public FDIndividual getIndividual(String code);

    public List<FDIndividual> queryIndividualList(FDIndividual condition);

    public Paginable<FDIndividual> queryIndividualPage(int start, int limit,
            FDIndividual condition);
}

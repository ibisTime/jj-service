/**
 * @Title FDIndividualAOImpl.java 
 * @Package com.xnjr.moom.ao.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午9:17:51 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IFDIndividualAO;
import com.xnjr.mall.bo.IFDIndividualBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.FDIndividual;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:17:51 
 * @history:
 */
@Service
public class FDIndividualAOImpl implements IFDIndividualAO {
    @Autowired
    IFDIndividualBO fdIndividualBO;

    @Override
    public FDIndividual getIndividual(String code) {
        return fdIndividualBO.getIndividual(code);
    }

    @Override
    public List<FDIndividual> queryIndividualList(FDIndividual condition) {
        return fdIndividualBO.queryIndividualList(condition);
    }

    @Override
    public Paginable<FDIndividual> queryIndividualPage(int start, int limit,
            FDIndividual condition) {
        return fdIndividualBO.getPaginable(start, limit, condition);
    }

}

/**
 * @Title FDIndividualBOImpl.java 
 * @Package com.xnjr.moom.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年4月22日 下午9:10:23 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDIndividualBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.IFDIndividualDAO;
import com.xnjr.mall.domain.FDIndividual;

/** 
 * @author: xieyj 
 * @since: 2016年4月22日 下午9:10:23 
 * @history:
 */
@Component
public class FDIndividualBOImpl extends PaginableBOImpl<FDIndividual> implements
        IFDIndividualBO {

    @Autowired
    private IFDIndividualDAO fdIndividualDAO;

    /** 
     * @see com.xnjr.mall.bo.IFDIndividualBO#getIndividual(java.lang.String)
     */
    @Override
    public FDIndividual getIndividual(String code) {
        FDIndividual data = null;
        if (StringUtils.isNotBlank(code)) {
            FDIndividual condition = new FDIndividual();
            condition.setCode(code);
            data = fdIndividualDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IFDIndividualBO#queryIndividualList(com.xnjr.mall.domain.FDIndividual)
     */
    @Override
    public List<FDIndividual> queryIndividualList(FDIndividual data) {
        return fdIndividualDAO.selectList(data);
    }
}

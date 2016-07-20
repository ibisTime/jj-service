/**
 * @Title IntegralBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月20日 下午6:13:57 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IIntegralBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IIntegralDAO;
import com.xnjr.mall.domain.Integral;

/** 
 * @author: xieyj 
 * @since: 2016年7月20日 下午6:13:57 
 * @history:
 */
@Component
public class IntegralBOImpl extends PaginableBOImpl<Integral> implements
        IIntegralBO {

    @Autowired
    private IIntegralDAO integralDAO;

    /** 
     * @see com.xnjr.mall.bo.IIntegralBO#saveIntegral(com.xnjr.mall.domain.Integral)
     */
    @Override
    public String saveIntegral(Integral data) {
        String code = null;
        if (data != null) {
            code = OrderNoGenerater.generateM(EGeneratePrefix.JF.getCode());
            data.setCode(code);
            integralDAO.insert(data);
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.IIntegralBO#queryIntegralList(com.xnjr.mall.domain.Integral)
     */
    @Override
    public List<Integral> queryIntegralList(Integral condition) {
        return integralDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IIntegralBO#getIntegral(java.lang.String)
     */
    @Override
    public Integral getIntegral(String code) {
        Integral condition = new Integral();
        condition.setCode(code);
        return integralDAO.select(condition);
    }
}

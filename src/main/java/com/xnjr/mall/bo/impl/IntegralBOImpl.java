/**
 * @Title IntegralBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author xieyj  
 * @date 2016年7月20日 下午6:13:57 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IIntegralBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.EGeneratePrefix;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IIntegralDAO;
import com.xnjr.mall.domain.Integral;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.exception.BizException;

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
            data.setUpdater(data.getUserId());
            data.setUpdateDatetime(new Date());
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
        Integral data = null;
        if (StringUtils.isNotBlank(code)) {
            Integral condition = new Integral();
            condition.setCode(code);
            data = integralDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "积分二维码编号不存在");
            }
        }
        return data;
    }

    /** 
     * @see com.xnjr.mall.bo.IIntegralBO#isExistIntegral(java.lang.String)
     */
    @Override
    public void isExistIntegral(String code) {
        if (StringUtils.isNotBlank(code)) {
            Integral condition = new Integral();
            condition.setCode(code);
            Integral data = integralDAO.select(condition);
            if (data == null) {
                throw new BizException("xn0000", "积分编号不存在");
            }
        }
    }

    /** 
     * @see com.xnjr.mall.bo.IIntegralBO#approveIntegral(java.lang.String, java.lang.String, java.lang.String, com.xnjr.mall.enums.EIntegralStatus)
     */
    @Override
    public int refreshIntegralStatus(String code, EBoolean status,
            String updater, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Integral data = new Integral();
            data.setCode(code);
            data.setStatus(status.getCode());
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = integralDAO.updateStatus(data);
        }
        return count;
    }

    /** 
     * @see com.xnjr.mall.bo.IIntegralBO#removeIntegral(java.lang.String)
     */
    @Override
    public int removeIntegral(String code) {
        int count = 0;
        if (StringUtils.isNotBlank(code)) {
            Integral data = new Integral();
            data.setCode(code);
            count = integralDAO.delete(data);
        }
        return count;
    }
}

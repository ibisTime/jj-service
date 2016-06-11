/**
 * @Title LogisticsBOImpl.java 
 * @Package com.xnjr.mall.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午12:57:10 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.ILogisticsBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.dao.ILogisticsDAO;
import com.xnjr.mall.domain.Logistics;
import com.xnjr.mall.enums.ELogisticsStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午12:57:10 
 * @history:
 */
@Component
public class LogisticsBOImpl extends PaginableBOImpl<Logistics> implements
        ILogisticsBO {

    @Autowired
    private ILogisticsDAO logisticsDAO;

    /** 
     * @see com.xnjr.mall.bo.ILogisticsBO#saveLogistics(com.xnjr.mall.domain.Logistics)
     */
    @Override
    public String saveLogistics(Logistics data) {
        String code = null;
        if (data != null) {
            Logistics condition = new Logistics();
            condition.setCode(data.getCode());
            if (getTotalCount(condition) > 0) {
                throw new BizException("xn000000", "物流单号已存在，不能重复添加");
            }
            logisticsDAO.insert(data);
            code = data.getCode();
        }
        return code;
    }

    /** 
     * @see com.xnjr.mall.bo.ILogisticsBO#getLogistics(java.lang.String)
     */
    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = null;
        if (StringUtils.isNotBlank(code)) {
            Logistics condition = new Logistics();
            condition.setCode(code);
            logistics = logisticsDAO.select(condition);
            if (logistics == null) {
                throw new BizException("xn000000", "物流单号不存在");
            }
        }
        return logistics;
    }

    @Override
    public Logistics getLogisticsByInvoiceCode(String invoiceCode) {
        Logistics logistics = null;
        if (StringUtils.isNotBlank(invoiceCode)) {
            Logistics condition = new Logistics();
            condition.setInvoiceCode(invoiceCode);
            logistics = logisticsDAO.select(condition);
            if (logistics == null) {
                throw new BizException("xn000000", "物流单号不存在");
            }
        }
        return logistics;
    }

    /** 
     * @see com.xnjr.mall.bo.ILogisticsBO#refreshLogisticsStatus(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshLogisticsStatus(String code, String updater, String remark) {
        // 校验code是否存在
        getLogistics(code);
        Logistics data = new Logistics();
        data.setCode(code);
        data.setStatus(ELogisticsStatus.RECIEVE.getCode());
        data.setUpdater(updater);
        data.setUpdateDatetime(new Date());
        data.setRemark(remark);
        return logisticsDAO.updateLogisticsStatus(data);
    }
}

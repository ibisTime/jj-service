/**
 * @Title LogisticsAOImpl.java 
 * @Package com.xnjr.mall.ao.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2016年5月29日 下午1:46:48 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xnjr.mall.ao.ILogisticsAO;
import com.xnjr.mall.bo.IGoodsBO;
import com.xnjr.mall.bo.IInvoiceBO;
import com.xnjr.mall.bo.ILogisticsBO;
import com.xnjr.mall.bo.IModelBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Invoice;
import com.xnjr.mall.domain.Logistics;
import com.xnjr.mall.enums.EInvoiceStatus;
import com.xnjr.mall.enums.ELogisticsStatus;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2016年5月29日 下午1:46:48 
 * @history:
 */
@Service
public class LogisticsAOImpl implements ILogisticsAO {

    @Autowired
    ILogisticsBO logisticsBO;

    @Autowired
    IGoodsBO goodsBO;

    @Autowired
    IModelBO modelBO;

    @Autowired
    IInvoiceBO invoiceBO;

    @Override
    @Transactional
    public String addLogistics(Logistics logistics) {
        // 保存物流单信息
        Invoice invoice = invoiceBO.getInvoice(logistics.getInvoiceCode());
        if (!EInvoiceStatus.PAY_START.getCode().equalsIgnoreCase(
            invoice.getStatus())) {
            throw new BizException("xn000000", "发货单未支付，不能发货");
        }
        // 无物流信息时，就不存物流信息。
        if (StringUtils.isNotBlank(logistics.getCode())) {
            logistics.setUserId(invoice.getApplyUser());
            logisticsBO.saveLogistics(logistics);
        }
        // 修改发货单状态
        invoiceBO.refreshInvoiceStatus(invoice.getCode(),
            EInvoiceStatus.SEND.getCode());
        return logistics.getCode();
    }

    @Override
    @Transactional
    public boolean confirmLogistics(String code, String updater, String remark) {
        // 判断单号是否存在
        Logistics data = logisticsBO.getLogistics(code);
        if (!ELogisticsStatus.TO_RECEIVE.getCode().equals(data.getStatus())) {
            throw new BizException("xn000000", "物流单状态不是待收货状态");
        }
        // 更新物流单状态为已收货状态
        logisticsBO.refreshLogisticsStatus(code, updater, remark);

        // 修改发货单状态,判断订单款项是否已经结清
        invoiceBO.refreshInvoiceStatus(data.getInvoiceCode(),
            EInvoiceStatus.RECEIVE.getCode());
        return true;
    }

    /** 
     * @see com.xnjr.mall.ao.ILogisticsAO#getLogistics(java.lang.String)
     */
    @Override
    public Logistics getLogistics(String code) {
        Logistics logistics = null;
        if (StringUtils.isNotBlank(code)) {
            logistics = logisticsBO.getLogistics(code);
            logistics.setGoodsList(goodsBO.queryGoodsInLogistics(code));
        }
        return logistics;
    }

    /** 
     * @see com.xnjr.mall.ao.ILogisticsAO#queryLogisticsPage(int, int, com.xnjr.mall.domain.Logistics)
     */
    @Override
    public Paginable<Logistics> queryLogisticsPage(int start, int limit,
            Logistics condition) {
        return logisticsBO.getPaginable(start, limit, condition);
    }

    private static boolean checkAdded(List<String> addedList, String modelCode) {
        for (String string : addedList) {
            if (string.equals(modelCode)) {
                return true;
            }
        }
        return false;
    }

}

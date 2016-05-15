/**
 * @Title HLOrderBOImpl.java 
 * @Package com.ibis.account.bo.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:22:32 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IHLOrderBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.core.OrderNoGenerater;
import com.xnjr.mall.dao.IHLOrderDAO;
import com.xnjr.mall.domain.HLOrder;
import com.xnjr.mall.enums.EBoolean;
import com.xnjr.mall.enums.EDirection;
import com.xnjr.mall.enums.EOrderStatus;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:22:32 
 * @history:
 */
@Component
public class HLOrderBOImpl extends PaginableBOImpl<HLOrder> implements
        IHLOrderBO {
    @Autowired
    private IHLOrderDAO hlOrderDAO;

    @Override
    public String saveHLOrder(String accountNumber, String type, Long amount,
            String updater, String remark) {
        String hlNo = null;
        if (StringUtils.isNotBlank(accountNumber) && amount != 0
                && StringUtils.isNotBlank(updater)
                && StringUtils.isNotBlank(remark)) {
            HLOrder data = new HLOrder();
            hlNo = OrderNoGenerater.generateM("HL");
            data.setHlNo(hlNo);
            data.setType(type);
            data.setStatus(EOrderStatus.todoAPPROVE.getCode());
            if (amount > 0) {
                data.setDirection(EDirection.PLUS.getCode());
                data.setAmount(amount);
            }
            if (amount < 0) {
                data.setDirection(EDirection.MINUS.getCode());
                data.setAmount(-amount);
            }
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setAccountNumber(accountNumber);
            data.setRemark(remark);
            hlOrderDAO.insert(data);
        }
        return hlNo;
    }

    /** 
     * @see com.ibis.account.bo.IHLOrderBO#refreshApproveOrder(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int refreshApproveOrder(String hlNo, String updater,
            String approveResult, String remark) {
        int count = 0;
        if (StringUtils.isNotBlank(hlNo) && StringUtils.isNotBlank(updater)
                && StringUtils.isNotBlank(approveResult)) {
            HLOrder data = new HLOrder();
            data.setHlNo(hlNo);
            if (EBoolean.YES.getCode().equalsIgnoreCase(approveResult)) {
                data.setStatus(EOrderStatus.APPROVE_YES.getCode());
            } else {
                data.setStatus(EOrderStatus.APPROVE_NO.getCode());
            }
            data.setUpdater(updater);
            data.setUpdateDatetime(new Date());
            data.setRemark(remark);
            count = hlOrderDAO.updateApproveOrder(data);

        }
        return count;
    }

    /** 
     * @see com.ibis.account.bo.IHLOrderBO#getHLOrder(java.lang.String)
     */
    @Override
    public HLOrder getHLOrder(String hlNo) {
        HLOrder data = null;
        if (StringUtils.isNotBlank(hlNo)) {
            HLOrder condition = new HLOrder();
            condition.setHlNo(hlNo);
            data = hlOrderDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IHLOrderBO#queryHLOrderList(com.ibis.account.domain.HLOrder)
     */
    @Override
    public List<HLOrder> queryHLOrderList(HLOrder data) {
        return hlOrderDAO.selectList(data);
    }

}

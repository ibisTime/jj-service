/**
 * @Title AJourBOImpl.java 
 * @Package com.ibis.account.bo.impl 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:22:07 
 * @version V1.0   
 */
package com.xnjr.mall.bo.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IFDAJourBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.dao.IFDAJourDAO;
import com.xnjr.mall.domain.FDAccountJour;
import com.xnjr.mall.enums.EAccountJourStatus;
import com.xnjr.mall.enums.EBoolean;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:22:07 
 * @history:
 */
@Component
public class FDAJourBOImpl extends PaginableBOImpl<FDAccountJour> implements
        IFDAJourBO {
    @Autowired
    private IFDAJourDAO fdAJourDAO;

    /** 
     * @see com.ibis.account.bo.IAJourBO#refreshCheckJour(java.lang.Long, java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public int doCheckAccount(Long aJNo, String checkUser, EBoolean checkResult) {
        int count = 0;
        if (aJNo > 0 && StringUtils.isNotBlank(checkUser)) {
            FDAccountJour data = new FDAccountJour();
            data.setAjNo(aJNo);
            data.setCheckUser(checkUser);
            data.setCheckDatetime(new Date());
            if (EBoolean.YES.getCode().equalsIgnoreCase(checkResult.getCode())) {
                data.setStatus(EAccountJourStatus.Done.getCode());
            } else {
                data.setStatus(EAccountJourStatus.Checked.getCode());
            }
            count = fdAJourDAO.doCheckAccount(data);

        }
        return count;
    }

    /** 
     * @see com.ibis.account.bo.IAJourBO#getAccountJour(java.lang.Long)
     */
    @Override
    public FDAccountJour getAccountJour(Long ajNo) {
        FDAccountJour data = null;
        if (ajNo > 0) {
            FDAccountJour condition = new FDAccountJour();
            condition.setAjNo(ajNo);
            data = fdAJourDAO.select(condition);
        }
        return data;
    }

    /** 
     * @see com.ibis.account.bo.IAJourBO#queryAccountJourList(com.ibis.account.domain.FDAccountJour)
     */
    @Override
    public List<FDAccountJour> queryAccountJourList(FDAccountJour condition) {
        return fdAJourDAO.selectList(condition);
    }

    /** 
     * @see com.xnjr.mall.bo.IFDAJourBO#addJour(java.lang.String, java.lang.Long, java.lang.Long, com.xnjr.mall.enums.EBizType, java.lang.String)
     */
    @Override
    public void addJour(String accountNumber, Long preAmount, Long amount,
            String bizType, String refNo, String remark) {
        Long postAmount = preAmount + amount;
        FDAccountJour accountJour = new FDAccountJour();
        accountJour.setStatus(EAccountJourStatus.todoCheck.getCode());
        accountJour.setBizType(bizType);
        accountJour.setRefNo(refNo);

        accountJour.setTransAmount(amount);
        accountJour.setPreAmount(preAmount);
        accountJour.setPostAmount(postAmount);
        accountJour.setRemark(remark);
        accountJour.setCreateDatetime(new Date());
        accountJour.setWorkDate(DateUtil
            .getToday(DateUtil.DB_DATE_FORMAT_STRING));
        accountJour.setAccountNumber(accountNumber);
        fdAJourDAO.insert(accountJour);
    }
}

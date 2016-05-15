package com.xnjr.mall.bo.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xnjr.mall.bo.IGSAccountBO;
import com.xnjr.mall.bo.base.PaginableBOImpl;
import com.xnjr.mall.common.DateUtil;
import com.xnjr.mall.core.AccountUtil;
import com.xnjr.mall.dao.IGSAJourDAO;
import com.xnjr.mall.dao.IGSAccountDAO;
import com.xnjr.mall.domain.GSAccount;
import com.xnjr.mall.domain.GSAccountJour;
import com.xnjr.mall.enums.EAccountJourStatus;
import com.xnjr.mall.enums.EGjsBizType;

/**
 * 
 * @author:duanjiewen 
 * @since: 2016年4月19日 下午4:15:46 
 * @history:
 */
@Component
public class GSAccountBOImpl extends PaginableBOImpl<GSAccount> implements
        IGSAccountBO {
    @Autowired
    IGSAccountDAO gsAccountDAO;

    @Autowired
    IGSAJourDAO gsAJourDAO;

    @Override
    public GSAccount getGSAccount() {
        GSAccount condition = new GSAccount();
        condition.setAccountNumber("GSACCOUNT");
        return gsAccountDAO.select(condition);
    }

    @Override
    public void refreshAmount(Long transAmount, EGjsBizType bizType,
            String refNo) {
        GSAccount dbAccount = this.getGSAccount();
        Long preAmount = dbAccount.getAmount();
        Long nowAmount = preAmount + transAmount;
        GSAccount account = new GSAccount();
        account.setAccountNumber("GSACCOUNT");
        account.setAmount(nowAmount);
        account.setMd5(AccountUtil.md5(nowAmount));
        account.setUpdateDatetime(new Date());
        gsAccountDAO.updateAmount(account);
        // 记录流水
        GSAccountJour jour = new GSAccountJour();
        jour.setStatus(EAccountJourStatus.todoCheck.getCode());
        jour.setBizType(bizType.getCode());
        jour.setRefNo(refNo);
        jour.setTransAmount(transAmount);
        jour.setPreAmount(preAmount);
        jour.setPostAmount(nowAmount);

        jour.setRemark(bizType.getValue());
        jour.setCreateDatetime(new Date());
        jour.setWorkDate(DateUtil.getToday(DateUtil.DB_DATE_FORMAT_STRING));
        jour.setAccountNumber("GSACCOUNT");
        gsAJourDAO.insert(jour);

    }

}

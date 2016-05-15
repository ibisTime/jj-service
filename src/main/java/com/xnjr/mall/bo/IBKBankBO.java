/**
 * @Title IBankBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-6-16 下午4:52:01 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.BKBank;

/** 
 * @author: miyb 
 * @since: 2015-6-16 下午4:52:01 
 * @history:
 */
public interface IBKBankBO extends IPaginableBO<BKBank> {
    public boolean isBKBankExist(String code);

    public int saveBKBank(BKBank data);

    public int removeBKBank(String code);

    public int refreshBkBank(BKBank data);

    public BKBank getBKBank(String code);

    public List<BKBank> queryBKBankList(BKBank data);
}

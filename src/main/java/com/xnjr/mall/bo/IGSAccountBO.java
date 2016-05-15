package com.xnjr.mall.bo;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.GSAccount;
import com.xnjr.mall.enums.EGjsBizType;

/**
 * 
 * @author: duanjiewen 
 * @since: 2016年4月19日 下午4:10:33 
 * @history:
 */
public interface IGSAccountBO extends IPaginableBO<GSAccount> {

    /**
     * 查询系统账户信息
     * @return 
     * @create: 2016年4月19日 下午4:12:41 duanjiewen
     * @history:
     */
    public GSAccount getGSAccount();

    /**
     * 更新余额
     * @param transAmount
     * @param bizType
     * @param refNo 
     * @create: 2016年4月19日 下午4:13:26 duanjiewen
     * @history:
     */
    public void refreshAmount(Long transAmount, EGjsBizType bizType,
            String refNo);
}

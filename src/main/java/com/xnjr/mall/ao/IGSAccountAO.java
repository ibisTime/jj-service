package com.xnjr.mall.ao;

import com.xnjr.mall.domain.GSAccount;
import com.xnjr.mall.spring.ServiceModule;

/**
 * 
 * @author: duanjiewen
 * @since: 2016年4月19日 下午4:43:29 
 * @history:
 */
@ServiceModule
public interface IGSAccountAO {
    /**
     * 查询系统账户信息
     * @return 
     * @create: 2016年4月19日 下午4:44:27 duanjiewen
     * @history:
     */
    public GSAccount getGSAccount();
}

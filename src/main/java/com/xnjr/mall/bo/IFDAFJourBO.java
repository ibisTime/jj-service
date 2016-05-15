/**
 * @Title IAFJourBO.java 
 * @Package com.ibis.account.bo 
 * @Description 
 * @author miyb  
 * @date 2015-3-15 下午3:18:03 
 * @version V1.0   
 */
package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.FDAccountFrozenJour;

/** 
 * @author: miyb 
 * @since: 2015-3-15 下午3:18:03 
 * @history:
 */
public interface IFDAFJourBO extends IPaginableBO<FDAccountFrozenJour> {
    /**
     * 获取单条冻结记录
     * @param afjNo
     * @return 
     * @create: 2015-5-5 上午11:16:43 miyb
     * @history:
     */
    public FDAccountFrozenJour getAFJour(Long afjNo);

    /**
     * 获取冻结记录列表
     * @param condition
     * @return 
     * @create: 2015-5-5 上午11:17:32 miyb
     * @history:
     */
    public List<FDAccountFrozenJour> queryAFJourList(
            FDAccountFrozenJour condition);
}

/**
 * @Title IContractAO.java 
 * @Package com.xnjr.pop.ao 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月14日 下午3:39:53 
 * @version V1.0   
 */
package com.xnjr.mall.ao;

import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Contract;
import com.xnjr.mall.spring.ServiceModule;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月14日 下午3:39:53 
 * @history:
 */
@ServiceModule
public interface IContractAO {

    String DEFAULT_ORDER_COLUMN = "code";

    /**
     * 电子合同分页查询
     * @param start
     * @param limit
     * @param condition
     * @return 
     * @create: 2015年11月19日 上午10:33:08 myb858
     * @history:
     */
    Paginable<Contract> queryContractPage(int start, int limit,
            Contract condition);

    Contract getContract(String contractCode);
}

/**
 * @Title ContractAOImpl.java 
 * @Package com.xnjr.pop.bo.impl 
 * @Description 
 * @author haiqingzheng  
 * @date 2015年11月14日 下午3:42:05 
 * @version V1.0   
 */
package com.xnjr.mall.ao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xnjr.mall.ao.IContractAO;
import com.xnjr.mall.bo.IContractBO;
import com.xnjr.mall.bo.base.Paginable;
import com.xnjr.mall.domain.Contract;
import com.xnjr.mall.exception.BizException;

/** 
 * @author: haiqingzheng 
 * @since: 2015年11月14日 下午3:42:05 
 * @history:
 */
@Service
public class ContractAOImpl implements IContractAO {
    @Autowired
    IContractBO contractBO;

    @Override
    public Paginable<Contract> queryContractPage(int start, int limit,
            Contract condition) {
        return contractBO.getPaginable(start, limit, condition);
    }

    @Override
    public Contract getContract(String contractCode) {
        Contract contract = contractBO.getContract(contractCode);
        if (contract == null) {
            throw new BizException("XN000001", "合同编号不存在");
        }
        return contract;
    }
}

package com.xnjr.mall.bo;

import java.util.List;

import com.xnjr.mall.bo.base.IPaginableBO;
import com.xnjr.mall.domain.Trace;

/** 
 * @author: xieyj 
 * @since: 2015年11月13日 上午11:03:47 
 * @history:
 */
public interface ITraceBO extends IPaginableBO<Trace> {

    public Trace getTrace(String code);

    public List<Trace> queryTraceList(Trace condition);

    public Long getTotalCountByBussinessAndUser(String userId,
            String businessCode);

    public String saveTrace(String companyCode, String businessCode, String type);
}

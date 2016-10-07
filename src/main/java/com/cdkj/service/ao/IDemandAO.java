package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Demand;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:16:11 
 * @history:
 */
public interface IDemandAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addDemand(Demand data);

    public int dropDemand(String code);

    public int editDemand(Demand data);

    public int violationDemand(String code, String dealer, String dealNote);

    public Paginable<Demand> queryDemandPage(int start, int limit,
            Demand condition);

    public List<Demand> queryDemandList(Demand condition);

    public Demand getDemand(String code);

}

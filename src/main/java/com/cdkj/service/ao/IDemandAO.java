package com.cdkj.service.ao;

import java.util.List;

import com.cdkj.service.bo.base.Paginable;
import com.cdkj.service.domain.Demand;
import com.cdkj.service.dto.req.XN612190Req;
import com.cdkj.service.dto.req.XN612192Req;

/**
 * @author: xieyj 
 * @since: 2016年10月7日 下午5:16:11 
 * @history:
 */
public interface IDemandAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String addDemand(XN612190Req req);

    public void dropDemand(String code);

    public void editDemand(XN612192Req req);

    public void violationDemand(String code, String dealer, String dealNote);

    public Paginable<Demand> queryDemandPage(int start, int limit,
            Demand condition);

    public List<Demand> queryDemandList(Demand condition);

    public Demand getDemand(String code);

}
